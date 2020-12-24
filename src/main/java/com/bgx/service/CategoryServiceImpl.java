package com.bgx.service;

import com.bgx.dao.CategoryDao;
import com.bgx.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao cd;


    @Override
    public Category queryById(Integer id) {
        return cd.queryById(id);
    }

    @Override
    public void save(Category category,Integer parentId) {

        if(StringUtils.isEmpty(parentId)){
            category.setLevels(1);
        }else{
            category.setLevels(2);
            category.setParentId(parentId);
        }
            cd.save(category);
    }
}
