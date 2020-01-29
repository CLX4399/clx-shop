package com.clx.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author CLX
 * @date 2020/1/23 21:44.
 */
@Data
public class PageResult<T> {

    // 总条数
    private Long total;
    // 总页数
    private Integer totalPage;
    // 当前页数据
    private List<T> items;

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
