package com.application.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class Health {

        @RequestMapping("/check")
        public String check() {
            return "OK";
        }
}
