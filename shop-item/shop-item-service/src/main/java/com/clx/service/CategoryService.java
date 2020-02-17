package com.clx.service;

import com.clxshop.item.pojo.Category;

import java.util.List;

/**
 * @author CLX
 * @date 2020/1/16 11:15.
 */
public interface CategoryService {

    /**
     * create by: CLX
     * description: 通过id获取
     * create time: 2020/1/16 11:25
     *
     * @param pid
     * @return
     */
    List queryCategoriesByPid(Long pid);

    /**
     * create by: CLX
     * description: 通过id获取品牌信息
     * create time: 2020/2/17 22:13
     *
     * @return
     * @Param: null
     */
    List<Category> queryByBrandId(Long bid);
}
