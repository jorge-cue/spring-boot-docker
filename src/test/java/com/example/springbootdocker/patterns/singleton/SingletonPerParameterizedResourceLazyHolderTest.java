package com.example.springbootdocker.patterns.singleton;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Created by jhcue on 20/02/2021
 */
class SingletonPerParameterizedResourceLazyHolderTest {

    @ParameterizedTest(name = "{index}: {0}")
    @CsvSource({
            "must be same object for same URL, http://store001.test.com, test1, apiKey1, http://store001.test.com, test4, apiKey4, true",
            "must not be same objects for different URL, http://store002.test.com, test2, apiKey2, http://store003.test.com, test3, apiKey3, false",
            "are same objects for same URL even with different user/apiKey, http://store004.test.com, test4, apiKey4, http://store004.test.com, test5, apiKey5, true"
    })
    void testCase(String name, String url1, String user1, String apiKey1, String url2, String user2, String apiKey2, boolean mustBeSame) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(url1);
        Objects.requireNonNull(url2);

        ParameterizedResource resource1 = ParameterizedResource.builder().url(url1).username(user1).apiKey(apiKey1).build();
        ParameterizedResource resource2 = ParameterizedResource.builder().url(url2).username(user2).apiKey(apiKey2).build();

        SingletonPerParameterizedResourceLazyHolder instance1 = SingletonPerParameterizedResourceLazyHolder.getInstance(resource1);
        SingletonPerParameterizedResourceLazyHolder instance2 = SingletonPerParameterizedResourceLazyHolder.getInstance(resource2);

        assertEquals(url1, instance1.getParameterizedResource().getUrl());
        assertEquals(url2, instance2.getParameterizedResource().getUrl());
        if (mustBeSame) assertSame(instance1, instance2, "must be same instances");
        else assertNotSame(instance1, instance2, "must be different instances");
    }
}