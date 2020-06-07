package cn.dblearn.blog.portal.timeline.service;

import cn.dblearn.blog.entity.timeline.Timeline;

import java.util.List;

/**
 * TimeLineService
 *
 * @author heyou
 * @date 2019/02/24 20:47
 * @email heyou_0423@163.com
 * @description
 */
public interface TimelineService {

    /**
     * 获取timeLine数据
     * @return
     */
    List<Timeline> listTimeLine();
}
