package cn.dblearn.blog.common.enums;

import lombok.Getter;

/**
 * CategoryRankEnum
 *
 * @author heyou
 * @date 2019/01/08 20:25
 * @email heyou_0423@163.com
 * @description 分类级别枚举
 */
@Getter
public enum CategoryRankEnum {

    /**
     * 一级
     */
    ROOT(-1),
    /**
     * 一级
     */
    FIRST(0),
    /**
     * 二级
     */
    SECOND(1),
    /**
     * 三级
     */
    THIRD(2);

    private int value;

    CategoryRankEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
