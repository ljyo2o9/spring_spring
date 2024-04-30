package com.example.demo.global.util.range;

import java.util.List;

public interface RangeableExecutor<T> {
    List<T> findInRange(Rangeable rangeable);
}
