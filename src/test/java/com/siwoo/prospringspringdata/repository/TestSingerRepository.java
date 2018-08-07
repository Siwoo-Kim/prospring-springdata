package com.siwoo.prospringspringdata.repository;

import com.siwoo.prospringspringdata.domain.Singer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author SiWoo Kim,
 * @version 1.0.0
 * @email sm123tt@gmail.com
 * @github : https://github.com/Siwoo-Kim
 * @since 2018-08-07 오전 11:59
 **/


public class TestSingerRepository {

    static SingerRepository singerRepository;

    @BeforeClass
    public static void setup() {
        singerRepository = new ClassPathXmlApplicationContext("spring/springdata-context.xml")
                .getBean(SingerRepository.class);
    }

    @Test
    public void findAll() {
        assertEquals(singerRepository.findAll().size(), 3);
    }

    @Test
    public void findByFirstNameAndLastName() {
        Singer singer = singerRepository.findByFirstNameAndLastName("Siwoo", "Kim")
                .stream()
                .findFirst()
                .orElse(null);
        assertNotNull(singer);
        System.out.println(singer);
    }

    @Test
    public void findFirstName() {
        Singer singer = singerRepository.findByFirstName("Siwoo")
                .stream()
                .findFirst()
                .orElse(null);
        assertNotNull(singer);
        System.out.println(singer);

        singer = singerRepository.findByFirstNameFetched("Siwoo")
                .stream()
                .findFirst()
                .orElse(null);
        assertNotNull(singer);
        singer.getAlbums().get(0);
        System.out.println(singer);
    }
}
