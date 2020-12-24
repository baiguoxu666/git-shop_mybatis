package com.bgx.util;

import java.util.Random;

public class RandomUtil {

    public static String getRandomSalt(Integer n){
        char[] array = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        String s="";
        Random random = new Random();
        for(int i=0;i<n;i++){
            s+=array[random.nextInt(array.length)];
        }

        return s;
    }

    public static void main(String[] args) {

        System.out.println(getRandomSalt(10));
    }
}
