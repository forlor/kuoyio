package com.kuoyio.xyz.test.controller;

import com.kuoyio.component.datajdbc.datasource.DataSourceTarget;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author xyz
 * @since 1.0
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/uid")
    public String uid() throws Throwable {
        jdbcTemplate.execute("select 1");
        throw new Throwable();
    }
}
