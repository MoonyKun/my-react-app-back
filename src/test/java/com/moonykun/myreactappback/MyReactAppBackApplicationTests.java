package com.moonykun.myreactappback;

import com.moonykun.myreactappback.server.UserServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyReactAppBackApplicationTests {

    @Autowired
    UserServer userServer;
    @Test
    void contextLoads() {
        long test = userServer.userRegister("test", "12345678", "12345678");
        System.out.println(test);
    }

}
