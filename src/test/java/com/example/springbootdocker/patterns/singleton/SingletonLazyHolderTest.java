package com.example.springbootdocker.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by jhcue on 19/02/2021
 */
class SingletonLazyHolderTest {

    @Test
    void getInstance() {
        SingletonLazyHolder instance = SingletonLazyHolder.getInstance();
        assertNotNull(instance, "Must be a non null object");
        assertSame(instance, SingletonLazyHolder.getInstance(), "Must be same instance");
    }
}