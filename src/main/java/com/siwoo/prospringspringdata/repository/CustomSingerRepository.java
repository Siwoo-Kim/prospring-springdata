package com.siwoo.prospringspringdata.repository;/**
 * @author SiWoo Kim,
 * @email sm123tt@gmail.com
 * @version 1.0.0
 * @github : https://github.com/Siwoo-Kim
 * @since 2018-08-07 오후 12:02
 **/

import com.siwoo.prospringspringdata.domain.Singer;

import java.util.List;

/**
 * @author SiWoo Kim, 
 * @email sm123tt@gmail.com
 * @version 1.0.0
 * @since 2018-08-07 오후 12:02
 * @github : https://github.com/Siwoo-Kim
 **/

public interface CustomSingerRepository {

    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);

}
