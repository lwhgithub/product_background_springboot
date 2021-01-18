package com.fh.product.product.service.impl;

import com.fh.common.ServerResponse;
import com.fh.product.brand.model.Brand;
import com.fh.product.product.mapper.ProductMapper;
import com.fh.product.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-18 20:44
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;


    @Override
    public ServerResponse getProductBrandData() {
        List<Brand> productbrandlist= productMapper.getProductBrandData();
        return ServerResponse.success(productbrandlist);
    }
}
