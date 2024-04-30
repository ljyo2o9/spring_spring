package com.example.demo.global.util.range;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface RangeableRepository<T, ID> extends Repository<T, ID>, RangeableExecutor<T> {
}
