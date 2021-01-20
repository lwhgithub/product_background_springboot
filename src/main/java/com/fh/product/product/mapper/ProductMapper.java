package com.fh.product.product.mapper;

import com.fh.product.brand.model.Brand;
import com.fh.product.product.model.Product;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-18 20:45
 */
public interface ProductMapper {
    List<Brand> getProductBrandData();

    List<Product> getProduct();

    void addProduct(Product product);

    void updateProduct(Product product);
}
