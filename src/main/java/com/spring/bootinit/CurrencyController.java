package com.spring.bootinit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private final ServiceConfiguration serviceConfiguration;

    public CurrencyController(ServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;
    }

    @RequestMapping("/currency-configuration")
    public ServiceConfiguration retrieveAllCourses() {
        System.out.println(serviceConfiguration.getUrl());
        return serviceConfiguration;
    }
}
