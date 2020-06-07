package cn.dblearn.blog.manage.article.service.impl;

import cn.dblearn.blog.common.enums.ModuleEnum;
import cn.dblearn.blog.common.util.PageUtils;
import cn.dblearn.blog.common.util.Query;
import cn.dblearn.blog.entity.article.Article;
import cn.dblearn.blog.entity.article.dto.ArticleDTO;
import cn.dblearn.blog.entity.article.vo.ArticleVO;
import cn.dblearn.blog.entity.operation.Tag;
import cn.dblearn.blog.mapper.article.ArticleMapper;
import cn.dblearn.blog.manage.article.service.ArticleService;
import cn.dblearn.blog.entity.operation.Category;
import cn.dblearn.blog.manage.operation.service.CategoryService;
import cn.dblearn.blog.manage.operation.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * articleAdminServiceImpl
 *
 * @author bobbi
 * @date 2018/11/21 12:48
 * @email 571002217@qq.com
 * @description
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询博文列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ArticleVO> page = new Query<ArticleVO>(params).getPage();
        List<ArticleVO> articleList = baseMapper.listArticleVo(page, params);
        for (ArticleVO articleVO : articleList){
            StringBuilder stringBuilder = new StringBuilder();
            List<String> categoryList = Arrays.asList(articleVO.getCategoryId().split(","));
            List<Category> categories = categoryService.queryCategoryListByIds(categoryList);
            List<Tag> tags = tagService.queryTagList(articleVO.getId(),0);
            Map<Integer, Category> categoryMap = categories.stream().collect(Collectors.toMap(Category::getId, c -> c));
            for(String categoryId : categoryList){
                Category category = categoryMap.get(Integer.parseInt(categoryId));
                stringBuilder.append(category.getName()).append("/");
            }
            articleVO.setCategoryListStr(stringBuilder.toString());
            articleVO.setTagList(tags);
        }
        page.setRecords(articleList);
        return new PageUtils(page);
    }



    /**
     * 保存博文文章
     *
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArticle(ArticleDTO article) {
        baseMapper.insert(article);
        tagService.saveTagAndNew(article.getTagList(),article.getId(),ModuleEnum.ARTICLE.getValue());
    }

    /**
     * 更新博文
     *
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticle(ArticleDTO article) {
        // 删除多对多所属标签
        tagService.deleteTagLink(article.getId(),ModuleEnum.ARTICLE.getValue());
        // 更新所属标签
        tagService.saveTagAndNew(article.getTagList(),article.getId(), ModuleEnum.ARTICLE.getValue());
        // 更新博文
        baseMapper.updateById(article);
    }

    /**
     * 获取文章对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleDTO getArticle(Integer articleId) {
        ArticleDTO articleDto = new ArticleDTO();
        Article article = this.baseMapper.selectById(articleId);
        BeanUtils.copyProperties(article,articleDto);
        // 查询所属标签
        articleDto.setTagList(tagService.listByLinkId(articleId,ModuleEnum.ARTICLE.getValue()));
        return articleDto;
    }

    @Override
    public boolean checkByCategory(Integer categoryId) {
        return baseMapper.checkByCategory(categoryId) > 0;
    }

    /**
     * 批量删除
     *
     * @param articleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Integer[] articleIds) {
        //先删除博文标签多对多关联
        Arrays.stream(articleIds).forEach(articleId -> {
            tagService.deleteTagLink(articleId,ModuleEnum.ARTICLE.getValue());
        });
        this.baseMapper.deleteBatchIds(Arrays.asList(articleIds));
    }


}
