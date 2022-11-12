package org.fam.spring.demo.by.type.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan("org.fam.spring.demo.by.type.repository"),
        @ComponentScan("org.fam.spring.demo.by.type.services")
})
public class AppConfig {
}
