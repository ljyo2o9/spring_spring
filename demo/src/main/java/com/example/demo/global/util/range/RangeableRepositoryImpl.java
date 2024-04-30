package com.example.demo.global.util.range;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

public class RangeableRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements RangeableRepository<T, ID> {

    public RangeableRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public List<T> findInRange(Rangeable rangeable) {
        TypedQuery<T> query = getQuery(null, rangeable.sort());

        query.setFirstResult(rangeable.first());
        query.setMaxResults(rangeable.limit());

        return query.getResultList();
    }
}
