package cn.dblearn.blog.entity.operation.vo;

import cn.dblearn.blog.entity.operation.Recommend;
import cn.dblearn.blog.entity.operation.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * RecommendVo
 *
 * @author heyou
 * @date 2019/02/22 10:49
 * @email heyou_0423@163.com
 * @description
 */
@Data
public class RecommendVO extends Recommend {

    private String description;

    private Long readNum;

    private Long commentNum;

    private Long likeNum;

    private String urlType;

    private String cover;

    private Date createTime;

    private List<Tag> tagList;

}
