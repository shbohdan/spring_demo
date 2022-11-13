package org.fam.spring.demo.by.type.util.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OldLifecycle implements InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(OldLifecycle.class);
    public static final String VALUE_FROM_INITIALIZING_BEAN = "value from InitializingBean";

    @Value("${some.scope.myProp}")
    private String text;

    public String getText() {
        return text;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet, init text={}", text);
        text = VALUE_FROM_INITIALIZING_BEAN;
        logger.info("afterPropertiesSet, new text={}", text);
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy");
    }
}
