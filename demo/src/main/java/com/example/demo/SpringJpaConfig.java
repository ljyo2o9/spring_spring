package com.example.demo;

import com.example.demo.global.util.range.RangeableRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = RangeableRepositoryImpl.class)
public class SpringJpaConfig {
}
