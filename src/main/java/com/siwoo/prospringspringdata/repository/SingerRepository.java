package com.siwoo.prospringspringdata.repository;

import com.siwoo.prospringspringdata.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author SiWoo Kim,
 * @version 1.0.0
 * @email sm123tt@gmail.com
 * @github : https://github.com/Siwoo-Kim
 * @since 2018-08-07 오전 11:56
 **/


public interface SingerRepository extends JpaRepository<Singer, Long>, CustomSingerRepository {

    List<Singer> findByFirstName(String firstName);

    @Query("select distinct s from Singer s left join fetch s.albums where s.firstName = :firstName ")
    List<Singer> findByFirstNameFetched(@Param("firstName") String firstName);

}
