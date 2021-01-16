package com.fh.product.category.mapper;

import com.fh.common.ServerResponse;
import com.fh.product.category.model.Category;

import java.util.List;
import java.util.Map;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-12 17:08
 */
public interface CategoryMapper {
    List<Map<String, Object>> queryProductCategory();


    int addProductCategory(Category category);

    void updateProductCategory(Category category);

    List<Category> queryProductCategoryPid(Integer pid);

    void updateProductCategoryson(Category category);
}
