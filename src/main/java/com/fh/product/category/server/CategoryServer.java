package com.fh.product.category.server;

import com.fh.common.ServerResponse;
import com.fh.product.category.model.Category;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-12 17:06
 */
public interface CategoryServer {
    ServerResponse queryProductCategory();

    ServerResponse addProductCategory(Category category);

    ServerResponse updateProductCategory(Category category);

    ServerResponse queryProductCategoryPid(Integer pid);

    ServerResponse getDataList();
}
