package com.fh.product.category.controller;

import com.fh.common.ServerResponse;
import com.fh.product.category.model.Category;
import com.fh.product.category.server.CategoryServer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-12 17:04
 */
@RestController
@RequestMapping("api/type/")
@CrossOrigin
public class CategoryController {
    @Resource
    private CategoryServer categoryServer;

    @GetMapping("getData")
    public ServerResponse queryProductCategory(){
        return categoryServer.queryProductCategory();
    }
    @GetMapping("getDataByPid")
    public ServerResponse queryProductCategoryPid(Integer pid){
        return categoryServer.queryProductCategoryPid(pid);
    }
    @PostMapping("add")
    public ServerResponse addProductCategory(Category category){
        return categoryServer.addProductCategory(category);
    }
    @PutMapping("update")
    public ServerResponse updateProductCategory(Category category){
        return categoryServer.updateProductCategory(category);
    }


}
