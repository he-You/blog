package cn.dblearn.blog.entity.timeline;

import lombok.Data;

import java.util.List;

/**
 * TimeLineMonh
 *
 * @author heyou
 * @date 2019/02/24 20:33
 * @email heyou_0423@163.com
 * @description
 */
@Data
public class TimelineMonth {

    private Integer month;

    private Integer count;

    private List<TimelinePost> posts;

}
