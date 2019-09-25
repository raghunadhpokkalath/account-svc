package com.anz.wd.accounts;
public class Application {

    public  String sayHello(){
        return "ANZ WD Hello SAY";
    }

    public static void main(String[] args){
        System.out.println(new Application().sayHello());
    }
}
