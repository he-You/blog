package cn.dblearn.blog.entity.article.dto;

import cn.dblearn.blog.entity.article.Article;
import cn.dblearn.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleDto
 *
 * @author heyou
 * @date 2019/01/08 19:04
 * @email heyou_0423@163.com
 * @description
 */
@Data
public class ArticleDTO extends Article {

    private List<Tag> tagList;

}
