package com.fh.product.product.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;
import com.fh.product.brand.model.Brand;
import com.fh.product.product.mapper.ProductMapper;
import com.fh.product.product.model.Product;
import com.fh.product.product.model.ProductPropertyPrice;
import com.fh.product.product.service.ProductService;
import com.fh.utils.OssUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    @Override
    public ServerResponse getProductData(Product product) {
        List<Product> products= productMapper.getProductData(product);
        long count = productMapper.getProductCount(product);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("Products",products);
        map.put("count",count);
        return ServerResponse.success(map);
    }




    @Override
    public ServerResponse updateProduct(Product product) {
        product.setProductUpdateDate(new Date());
        if (StringUtils.isNotBlank(product.getNewproductImgPath())){
            if(StringUtils.isNotBlank(product.getProductImgPath())){
                OssUtil.deleteFile(product.getProductImgPath());
            }
            product.setProductImgPath(product.getNewproductImgPath());
        }
        productMapper.updateProduct(product);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse addProduct(Product product, String property, String sku) {
//返回主键 keyProperty="id" useGeneratedKeys="true"
        product.setProductAuthor("admin");
        product.setProductIsDel(1);
        product.setProductCreateDate(new Date());
        product.setProductUpdateDate(new Date());
        int insertNum = productMapper.addProduct(product);
        // 声明属性数据的对象
        List<ProductPropertyPrice> adList=new ArrayList<>();
        //批量新增
        //将attr的json数组字符串 转为json数组对象
        JSONArray objects = JSONObject.parseArray(property);
        for (int i = 0; i <objects.size() ; i++) {
            //构建属性数据对象
            ProductPropertyPrice productPropertyPrice=new ProductPropertyPrice();
            //设置对应的商品id
            productPropertyPrice.setProductId(product.getProductId());
            productPropertyPrice.setProductProperty(objects.get(i).toString());
            //放入集合
            adList.add(productPropertyPrice);
        }

        //将sku的json数组字符串 转为json数组对象
        JSONArray objectssku = JSONObject.parseArray(sku);
        for (int i = 0; i <objectssku.size() ; i++) {
            //得到具体一个json对象
            JSONObject dataJs= (JSONObject) objectssku.get(i);
            //构建属性数据对象
            ProductPropertyPrice productPropertyPrice=new ProductPropertyPrice();
            //设置对应的商品id
            productPropertyPrice.setProductId(product.getProductId());
            productPropertyPrice.setProductPrice(dataJs.getBigDecimal("productPrice"));
            productPropertyPrice.setProductStocks(dataJs.getInteger("productStocks"));
            dataJs.remove("productPrice");
            dataJs.remove("productStocks");
            productPropertyPrice.setProductProperty(objectssku.get(i).toString());
            //放入集合
            adList.add(productPropertyPrice);
        }
        //批量新增
        productMapper.addProductProperty(adList);
        return ServerResponse.success();
    }
}
