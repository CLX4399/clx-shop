package com.clx.mapper;

import com.clxshop.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author CLX
 * @date 2020/1/16 11:21.
 */
public interface CategoryMapper extends Mapper<Category> {

    @Select("SELECT * FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);

}
