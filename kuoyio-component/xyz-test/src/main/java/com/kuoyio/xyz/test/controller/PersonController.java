package com.kuoyio.xyz.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xyz
 * @since 1.0
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/uid")
    public String uid(){
        return UUID.randomUUID().toString();
    }
}
