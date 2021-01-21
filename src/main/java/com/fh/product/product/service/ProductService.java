package com.fh.product.product.service;

import com.fh.common.ServerResponse;
import com.fh.product.product.model.Product;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-18 20:44
 */
public interface ProductService {
    ServerResponse getProductBrandData();

    ServerResponse getProduct();



    ServerResponse updateProduct(Product product);

    ServerResponse addProduct(Product product, String property, String sku);
}
