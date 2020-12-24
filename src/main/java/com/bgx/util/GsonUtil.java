package com.bgx.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GsonUtil {

    public static void writeToResponse(HttpServletResponse response,Object o){

        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            String json = new Gson().toJson(o);
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
