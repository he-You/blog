package cn.dblearn.blog.portal.operation.service.impl;

import cn.dblearn.blog.entity.operation.Link;
import cn.dblearn.blog.mapper.operation.LinkMapper;
import cn.dblearn.blog.portal.operation.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LinkService
 *
 * @author heyou
 * @date 2019/02/21 17:10
 * @email heyou_0423@163.com
 * @description
 */
@Service("linkPortalService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    /**
     * 获取link列表
     *
     * @return
     */
    @Override
    public List<Link> listLink() {
        return baseMapper.selectList(null);
    }
}
