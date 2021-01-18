package com.fh.product.product.controller;

import com.fh.common.ServerResponse;
import com.fh.product.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-18 20:42
 */
@RestController
@RequestMapping("api/product/")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("getProductBrandData")
    public ServerResponse getProductBrandData(){
        return productService.getProductBrandData();
    }
}
