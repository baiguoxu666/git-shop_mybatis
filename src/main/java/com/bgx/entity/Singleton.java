package com.bgx.entity;

public class Singleton {

    private static Singleton singleton=new Singleton();

    //构造方法不要加static
    private Singleton(){

    }


    public static Singleton getInstance(){
        return singleton;
    }
}
