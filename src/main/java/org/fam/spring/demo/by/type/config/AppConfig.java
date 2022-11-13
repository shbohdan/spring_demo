package org.fam.spring.demo.by.type.config;

import org.fam.spring.demo.by.type.util.beans.AnnotationLifecycle;
import org.fam.spring.demo.by.type.util.beans.MultipleBeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan("org.fam.spring.demo.by.type.repository"),
        @ComponentScan("org.fam.spring.demo.by.type.services")
})
public class AppConfig {

    @Bean
    public AnnotationLifecycle annotationLifecycle(@Value("${some.scope.myProp}") String text) {
        return new AnnotationLifecycle(text);
    }

    @Bean
    public MultipleBeans firstBean() {
        return new MultipleBeans(annotationLifecycle("first"));
    }

    @Bean
    public MultipleBeans secondBean() {
        return new MultipleBeans(annotationLifecycle("second"));
    }
}
