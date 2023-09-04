package com.moonykun.myreactappback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Moonykun
 */
@EnableSwagger2
@SpringBootApplication
public class MyReactAppBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyReactAppBackApplication.class, args);
    }
}
