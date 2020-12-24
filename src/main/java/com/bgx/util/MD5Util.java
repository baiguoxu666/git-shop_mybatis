package com.bgx.util;

import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String getMD5(String password){
        MessageDigest md5 = null;
        char[] encode=null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            encode = Hex.encode(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return new String(encode);

    }


    public static void main(String[] args) {
        System.out.println(getMD5("123456"));
    }
}
