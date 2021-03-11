package com.fh.product.product.mapper;

import com.fh.product.brand.model.Brand;
import com.fh.product.product.model.Product;
import com.fh.product.product.model.ProductPropertyPrice;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-18 20:45
 */
public interface ProductMapper {
    List<Brand> getProductBrandData();

    List<Product> getProductData(Product product);

    long getProductCount(Product product);

    int addProduct(Product product);

    void updateProduct(Product product);
    @Insert("<script>insert into product_property_price (productId,productProperty,productStocks,productPrice) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.productId},#{a.productProperty},#{a.productStocks},#{a.productPrice} )  </foreach> </script>")
    void addProductProperty(List<ProductPropertyPrice> adList);


}
