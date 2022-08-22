package cn.com.uestc.utils;

import cn.hutool.core.collection.CollUtil;

import java.util.List;
import java.util.function.Consumer;

public class ListOptionalUtil {

    public static <T> void ofNull(List<T> list, Consumer<List<T>> consumer) {
        if (CollUtil.isNotEmpty(list)) consumer.accept(list);
    }
}
