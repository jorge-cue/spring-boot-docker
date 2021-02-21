package com.example.springbootdocker.patterns.singleton;

/*
 * Created by jhcue on 19/02/2021
 */
public class SingletonLazyHolder {

    private SingletonLazyHolder() {}

    private static class LazyHolder {
        private static SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstance() {
        return LazyHolder.INSTANCE;
    }
}
