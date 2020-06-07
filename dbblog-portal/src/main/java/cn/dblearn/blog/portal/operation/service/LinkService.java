package cn.dblearn.blog.portal.operation.service;

import cn.dblearn.blog.entity.operation.Link;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * LinkService
 *
 * @author heyou
 * @date 2019/02/21 17:09
 * @email heyou_0423@163.com
 * @description
 */
public interface LinkService extends IService<Link> {

    /**
     * 获取link列表
     * @return
     */
    List<Link> listLink();
}
