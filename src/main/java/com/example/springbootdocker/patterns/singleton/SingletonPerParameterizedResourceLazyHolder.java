package com.example.springbootdocker.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by jhcue on 20/02/2021
 */
public class SingletonPerParameterizedResourceLazyHolder {

    private final ParameterizedResource parameterizedResource;

    private SingletonPerParameterizedResourceLazyHolder(ParameterizedResource parameterizedResource) {
        this.parameterizedResource = parameterizedResource;
    }

    public ParameterizedResource getParameterizedResource() {
        return parameterizedResource;
    }

    private static class LazyHolder {
        private static final Map<String, SingletonPerParameterizedResourceLazyHolder> INSTANCES = new HashMap<>();
    }

    public static SingletonPerParameterizedResourceLazyHolder getInstance(ParameterizedResource resource) {
        return LazyHolder.INSTANCES.computeIfAbsent(resource.getUrl(),
                url -> new SingletonPerParameterizedResourceLazyHolder(resource));
    }
}
