package org.fam.spring.demo.by.type.util;

import java.util.List;
import java.util.stream.StreamSupport;

public class CollectionUtils {
    public static <T> List<T> toList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }
}
