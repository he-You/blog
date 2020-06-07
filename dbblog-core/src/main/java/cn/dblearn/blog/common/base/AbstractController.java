package cn.dblearn.blog.common.base;

import cn.dblearn.blog.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * AbstractController
 *
 * @author heyou
 * @date 2018/10/22 12:35
 * @email heyou_0423@163.com
 * @description
 */
public class AbstractController {

    protected SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId(){
        return getUser().getUserId();
    }
}
