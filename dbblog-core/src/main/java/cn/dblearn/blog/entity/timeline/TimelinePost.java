package cn.dblearn.blog.entity.timeline;

import lombok.Data;

import java.util.Date;

/**
 * TimeLineData
 *
 * @author heyou
 * @date 2019/02/24 20:39
 * @email heyou_0423@163.com
 * @description
 */
@Data
public class TimelinePost {

    private Integer id;

    private String title;

    private String description;

    private String postType;

    private Date createTime;

}
