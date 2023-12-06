package com.kuoyio.component.datajdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xyz
 * @since 1.0
 */
@DataJdbcTest
@AutoConfigureTestDatabase
public class KuoyioJdbcAutoConfigurationTest {

    @Test
    public void test(){
        System.out.println(1);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}
