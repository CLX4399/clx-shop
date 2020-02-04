package com.clx.service;

import com.clx.pojo.PageResult;
import com.clxshop.item.pojo.Brand;

import java.util.List;

/**
 * @author CLX
 * @date 2020/1/23 21:41.
 */
public interface BrandService {

    /**
     * create by: CLX
     * description: 分页获取品牌数据
     * create time: 2020/1/24 1:24
     *
     * @return
     * @Param: null
     */
    PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    void saveBrand(Brand brand, List<Long> cids);

    void updateBrand(Brand brand);
}
