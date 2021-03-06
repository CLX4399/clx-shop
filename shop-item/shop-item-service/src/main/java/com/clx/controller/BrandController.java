package com.clx.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.clx.pojo.PageResult;
import com.clx.service.BrandService;
import com.clxshop.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author CLX
 * @date 2020/1/23 22:09.
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * create by: CLX
     * description: 获取页面数据
     * create time: 2020/2/15 23:21
     *
     * @return
     * @Param: null
     */
    @RequestMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandsByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", required = false) Boolean desc
    ) {
        PageResult<Brand> result = this.brandService.queryBrandsByPage(key, page, rows, sortBy, desc);
        if (CollectionUtil.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    /**
     * create by: CLX
     * description: 保存新增品牌
     * create time: 2020/2/15 23:21
     *
     * @return
     * @Param: null
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {

        this.brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     * create by: CLX
     * description: 修改品牌信息
     * create time: 2020/2/15 23:22
     *
     * @return
     * @Param: null
     */
    @PutMapping
    public ResponseEntity<Void> updateBrand(Brand brand) {
        this.brandService.updateBrand(brand);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
