package com.clx.mapper;

import com.clxshop.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author CLX
 * @date 2020/1/23 21:41.
 */
public interface BrandMapper extends Mapper<Brand> {


    /**
     * @param id
     * @param cid
     */
    @Insert("insert into tb_category_brand (category_id, brand_id) values (#{category_id},#{brand_id});")
    void saveBrand(@Param("brand_id") Long id, @Param("category_id") Long cid);

}
