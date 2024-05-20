package com.application.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Index {

        @RequestMapping("/")
        public String index() {
            return "Welcome to the REST API";
        }
}
