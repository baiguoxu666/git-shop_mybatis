package com.bgx.controller;

import com.bgx.entity.Category;
import com.bgx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService cs;

    @RequestMapping("query")
    public String query(Integer id) {
        System.out.println(cs.queryById(id));
        return null;
    }


    @RequestMapping("save")
    public String save(Category category, Integer parentId) {

        try {
            cs.save(category, parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
            System.out.println("这是master分支");
            System.out.println("这是dev分支");			 
			System.out.println("这是第三次提交");
	        System.out.println("这是第六次提交");
            System.out.println("这是第三次提交");
            System.out.println("这是第四次提交");
            System.out.println("这是第五次提交");
            return null;
        }
    }

