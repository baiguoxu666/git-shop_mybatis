package com.bgx.controller;

import com.bgx.entity.User;
import com.bgx.service.UserService;
import com.bgx.util.GsonUtil;
import com.bgx.util.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("image")
    public String imageCode(HttpServletRequest request, HttpServletResponse response){
        try {
            String securityCode = ValidateImageCodeUtils.getSecurityCode();
            request.getSession().setAttribute("code", securityCode);
            BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
            ServletOutputStream os = response.getOutputStream();

            ImageIO.write(image, "png", os);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @RequestMapping("regist")
    public String regist(User user){
        us.insert(user);
        return null;
    }



    @RequestMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(User user,String enCode,Boolean isRememberUsername
            ,HttpServletRequest request,HttpServletResponse response){

        HashMap<String, Object> map = new HashMap<>();

        String c = (String) request.getSession().getAttribute("code");
        if(!c.equalsIgnoreCase(enCode)){
            map.put("success",false);
            map.put("message","验证码错误");
        }else
        try {
            User u = us.select(user);
            request.getSession().setAttribute("user",u);

            if(isRememberUsername!=false){
                Cookie cookie = new Cookie("username", URLEncoder.encode(u.getName(),"utf-8"));
                cookie.setMaxAge(3600*24*7);
                cookie.setPath("/shop");
                response.addCookie(cookie);
            }else {
                Cookie cookie = new Cookie("username", null);
                cookie.setMaxAge(0);
                cookie.setPath("/shop");
                response.addCookie(cookie);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }


}
