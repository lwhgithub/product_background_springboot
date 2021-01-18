package com.fh.product.category.server.impl;

import com.alibaba.fastjson.JSONArray;
import com.fh.common.ServerResponse;
import com.fh.product.category.mapper.CategoryMapper;
import com.fh.product.category.model.Category;
import com.fh.product.category.server.CategoryServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-12 17:07
 */
@Service
public class CategoryServerImpl implements CategoryServer {
    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public ServerResponse queryProductCategory() {
        List<Map<String,Object>> allList = categoryMapper.queryProductCategory();
        List<Map<String,Object>> parentList = new ArrayList<>();
        for (Map<String,Object> allMap : allList){
            if (allMap.get("pid").equals(0)){
                parentList.add(allMap);
            }
        }
        getztrraList(allList,parentList);
        String jsonString = JSONArray.toJSONString(parentList);
        return ServerResponse.success(parentList);
    }

    @Override
    public ServerResponse addProductCategory(Category category) {
        category.setCreateDate(new Date());
        int insertNum =categoryMapper.addProductCategory(category);
        return ServerResponse.success(category.getId());
    }

    @Override
    public ServerResponse updateProductCategory(Category category) {
        category.setUpdateDate(new Date());
        category.setUpdatePersonName("admin");
        categoryMapper.updateProductCategory(category);
        if(!category.getIsDel().equals(category.getNewisDel())){
            category.setUpdatePersonName("admin");
            categoryMapper.updateProductCategoryson(category);
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse queryProductCategoryPid(Integer pid) {
        List<Category> categorylist = categoryMapper.queryProductCategoryPid(pid);
        return ServerResponse.success(categorylist);
    }

    @Override
    public ServerResponse getDataList() {
        List<Category> categoryList = categoryMapper.getDataList();
        return ServerResponse.success(categoryList);
    }


    private void getztrraList(List<Map<String,Object>> allList,List<Map<String,Object>> parentList){
    if (parentList != null && parentList.size()>0){
        for (Map<String,Object> parentmap : parentList){
            List<Map<String,Object>> childrenList = new ArrayList<>();
            for(Map<String,Object> allmap : allList){
                if(parentmap.get("id").equals(allmap.get("pid"))){
                    childrenList.add(allmap);
                }
            }
            if (childrenList.size()>0){
                parentmap.put("children",childrenList);
                getztrraList(allList,childrenList);
            }
        }
    }
    }

}
