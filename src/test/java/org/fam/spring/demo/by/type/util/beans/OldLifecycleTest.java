package org.fam.spring.demo.by.type.util.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.fam.spring.demo.by.type.util.beans.OldLifecycle.VALUE_FROM_INITIALIZING_BEAN;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OldLifecycleTest {

    @Autowired
    private OldLifecycle component;

    @Test
    void shouldCallPostConstructCode() {
        assertEquals(VALUE_FROM_INITIALIZING_BEAN, component.getText());
    }
}