package cn.dblearn.blog.portal.timeline.controller;

import cn.dblearn.blog.common.Result;
import cn.dblearn.blog.entity.timeline.Timeline;
import cn.dblearn.blog.portal.timeline.service.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TimeLineController
 *
 * @author heyou
 * @date 2019/02/24 20:46
 * @email heyou_0423@163.com
 * @description
 */
@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Resource
    private TimelineService timelineService;

    @GetMapping("")
    public Result listTimeline() {
        List<Timeline> timelineList = timelineService.listTimeLine();

        return Result.ok().put("timelineList",timelineList);
    }
}
