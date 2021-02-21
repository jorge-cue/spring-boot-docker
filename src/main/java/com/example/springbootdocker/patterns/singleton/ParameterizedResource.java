package com.example.springbootdocker.patterns.singleton;

import lombok.Builder;
import lombok.Data;

/*
 * Created by jhcue on 20/02/2021
 */
@Data
@Builder
public class ParameterizedResource {
    private final String url;
    private final String username;
    private final String apiKey;
}
