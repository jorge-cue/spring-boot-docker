package com.example.springbootdocker.patterns.singleton;

/*
 * Created by jhcue on 19/02/2021
 */
public class SingletonDoubleCheckLock {

    private SingletonDoubleCheckLock() {}

    private volatile static SingletonDoubleCheckLock INSTANCE;

    public static SingletonDoubleCheckLock getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }
}
