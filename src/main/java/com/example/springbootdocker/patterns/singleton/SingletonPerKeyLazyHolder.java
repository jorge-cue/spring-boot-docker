package com.example.springbootdocker.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates a singleton object per each provided key, for example, to be sure we create a singleton object for each
 * named resource in the system, for example in a look for best price from a list of stores this pattern can create
 * a singleton control object for each downstream store containing specific information to access each store, such as
 * URL, HttpClient, API_KEY and at the same time we can be sure that there are no duplicated object for any given store.
 *
 * Pros:
 *    We have a single object for each resource.
 *
 * Cons:
 *    Since INSTANCES are handled in a Hard reference object (Map) then the Singleton Object will not be released until
 *    the
 *
 * Created by jhcue on 19/02/2021.
 */
public class SingletonPerKeyLazyHolder {

    private final String key;

    private SingletonPerKeyLazyHolder(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    private static class LazyHolder {
        private static final Map<String, SingletonPerKeyLazyHolder> INSTANCES = new HashMap<>();
    }

    public static SingletonPerKeyLazyHolder getInstance(String key) {
        return LazyHolder.INSTANCES.computeIfAbsent(key, SingletonPerKeyLazyHolder::new);
    }
}
