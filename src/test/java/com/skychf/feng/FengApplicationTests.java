package com.skychf.feng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FengApplicationTests {

    @Test
    public void contextLoads() {
       System.err.println( new Date(System.currentTimeMillis() + 300) );
    }

}
