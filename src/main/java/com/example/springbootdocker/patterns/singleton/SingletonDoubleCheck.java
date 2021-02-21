package com.example.springbootdocker.patterns.singleton;

/*
 * Created by jhcue on 20/02/2021
 */
public class SingletonDoubleCheck {

    private static volatile SingletonDoubleCheck INSTANCE = null;

    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
