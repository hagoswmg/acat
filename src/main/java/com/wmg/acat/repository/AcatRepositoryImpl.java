package com.wmg.acat.repository;

import com.wmg.acat.model.AcatModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class AcatRepositoryImpl implements AcatRepository {

    private final EntityManager entityManager;

    public AcatRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AcatModel> findAll(String limit) {
        final String EMPTY = " ";

        String SQL_QUERY = SELECT_QUERY + EMPTY + WHERE_CLAUSE;
        if (limit.equalsIgnoreCase("true")) {
            SQL_QUERY += EMPTY + "AND ROWNUM < 21";
        }
        SQL_QUERY += EMPTY + ORDER_BY;

        Query nativeQuery = entityManager.createNativeQuery(SQL_QUERY, "AcatModel");

        return nativeQuery.getResultList();
    }
}
