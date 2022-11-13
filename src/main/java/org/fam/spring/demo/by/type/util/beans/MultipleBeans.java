package org.fam.spring.demo.by.type.util.beans;

public class MultipleBeans {

    private final AnnotationLifecycle annotationLifecycle;

    public MultipleBeans(AnnotationLifecycle annotationLifecycle) {
        this.annotationLifecycle = annotationLifecycle;
    }

    public String getText() {
        return annotationLifecycle.getText();
    }
}
