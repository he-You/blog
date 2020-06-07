package cn.dblearn.blog.entity.timeline;

import lombok.Data;

import java.util.List;

/**
 * TimeLine
 *
 * @author heyou
 * @date 2019/02/24 20:33
 * @email heyou_0423@163.com
 * @description
 */
@Data
public class Timeline {

    private Integer year;

    private Integer count;

    private List<TimelineMonth> months;
}
