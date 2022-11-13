package org.fam.spring.demo.by.type.util.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MultipleBeansTest {

    @Autowired
    private MultipleBeans firstBean;
    @Autowired
    private MultipleBeans secondBean;

    @Test
    void firstBeanTest() {
        assertEquals("first", firstBean.getText());
    }

    @Test
    void secondBeanTest() {
        assertEquals("second", secondBean.getText());
    }
}