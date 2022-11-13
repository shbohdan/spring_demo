package org.fam.spring.demo.by.type.util.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationLifecycle.class);

    private final String text;

    public AnnotationLifecycle(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @PostConstruct
    public void start() {
        logger.info("from post construct method");
    }

    @PreDestroy
    public void finish() {
        logger.info("from destroy method");
    }
}
