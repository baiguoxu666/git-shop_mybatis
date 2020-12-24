package com.bgx.dao;


import com.bgx.entity.Category;
import org.mybatis.spring.annotation.MapperScan;

public interface CategoryDao {

    Category queryById(Integer id);
    void save(Category category);
}
