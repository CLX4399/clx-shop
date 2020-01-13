package com.clx.service;

import com.clxshop.item.pojo.Category;
import org.springframework.stereotype.Service;
import sun.reflect.generics.scope.MethodScope;

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

}
