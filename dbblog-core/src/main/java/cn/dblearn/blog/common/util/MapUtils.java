package cn.dblearn.blog.common.util;

import java.util.HashMap;

/**
 * MapUtils
 *
 * @author heyou
 * @date 2018/10/22 19:38
 * @email heyou_0423@163.com
 * @description Map工具类
 */
public class MapUtils extends HashMap<String,Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key,value);
        return this;
    }
}
