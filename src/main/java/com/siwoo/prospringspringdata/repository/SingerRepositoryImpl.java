package com.siwoo.prospringspringdata.repository;

import com.siwoo.prospringspringdata.domain.Singer;
import com.siwoo.prospringspringdata.domain.Singer_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author SiWoo Kim,
 * @version 1.0.0
 * @email sm123tt@gmail.com
 * @github : https://github.com/Siwoo-Kim
 * @since 2018-08-07 오후 12:03
 **/


@Repository
@Transactional(readOnly = true)
public class SingerRepositoryImpl implements CustomSingerRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Singer> query = cb.createQuery(Singer.class);
        Root<Singer> singerRoot = query.from(Singer.class);
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);

        Predicate criteria = cb.conjunction();
        if(StringUtils.hasText(firstName)) {
            Predicate p = cb.equal(singerRoot.get(Singer_.firstName), firstName);
            criteria = cb.and(p, criteria);
        }
        if(StringUtils.hasText(lastName)) {
            Predicate p = cb.equal(singerRoot.get(Singer_.lastName), lastName);
            criteria = cb.and(p, criteria);
        }

        return entityManager.createQuery(query
                .select(singerRoot)
                .distinct(true)
                .where(criteria))
                .getResultList();
    }
}
