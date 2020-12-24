package com.bgx.service;

import com.bgx.entity.Category;

public interface CategoryService {
    Category queryById(Integer id);
    void save(Category category,Integer parentId);

}
