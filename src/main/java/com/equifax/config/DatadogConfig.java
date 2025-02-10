package com.equifax.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatadogConfig {

    @Bean
    public DDSketch datadogSketch() {
        return DDSketches.unboundedDense();
    }
}
