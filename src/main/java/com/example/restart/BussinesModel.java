package com.example.restart;

public class BussinesModel {
    public static Object run(Boolean... Logics) {
        for (boolean logic: Logics) {
            if (!logic){
                return null;
            }
        }
        return new Object();
    }

}
