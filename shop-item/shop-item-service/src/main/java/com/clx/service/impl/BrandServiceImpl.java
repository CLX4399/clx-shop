package com.clx.service.impl;

import com.clx.mapper.BrandMapper;
import com.clx.pojo.PageResult;
import com.clx.service.BrandService;
import com.clxshop.item.pojo.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author CLX
 * @date 2020/1/23 21:42.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {

        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        PageHelper.startPage(page, rows);

        if (StringUtils.isNotBlank(sortBy) && desc != null) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }

        List<Brand> brands = this.brandMapper.selectByExample(example);
        //包装为pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);

        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBrand(Brand brand, List<Long> cids) {
        //处理Brand数据保存到tb_brand
        this.brandMapper.insertSelective(brand);

        //在中间表中增加
        cids.forEach(cid -> {
                    this.brandMapper.saveBrand(brand.getId(), cid);
                }
        );
    }
}
