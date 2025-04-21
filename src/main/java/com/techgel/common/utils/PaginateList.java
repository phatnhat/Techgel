package com.techgel.common.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

public abstract class PaginateList {
    public static <T> Page<T> page(List<T> list, Pageable pageable) {
        if (list == null || pageable == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        int total = list.size();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), total);

        if (start > total) {
            return new PageImpl<>(Collections.emptyList(), pageable, total);
        }

        return new PageImpl<>(list.subList(start, end), pageable, total);
    }
}
