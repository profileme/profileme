package com.profileme.repo;

import com.profileme.entity.ProfileHeader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProfileHeaderRepoTest {

    @Autowired
    private ProfileHeaderRepo profileHeaderRepo;

    @Autowired
    TestEntityManager entityManager;

    ProfileHeader headerToFetch;
    ProfileHeader headerToSave;

    @BeforeEach
    void setUp() {

        try {
            headerToFetch = ProfileHeader.builder().birthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1983-06-22"))
                    .name("Anas Ibraheem").country("jordan").city("karak").email("anas.alsarairah@gmail.com").maritialStatus("single")
                    .nationality("jordanian").mobile("0797289609").build();

            entityManager.persist(headerToFetch);

            headerToSave = ProfileHeader.builder().birthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1983-06-22"))
                    .name("Anas Ibraheem").country("jordan").city("karak").email("anas.alsarairah@gmail.com").maritialStatus("single")
                    .nationality("jordanian").mobile("0797289609").build();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById(){
        Optional<ProfileHeader> profileHeaderById = profileHeaderRepo.findById(1L);
        assertSame(profileHeaderById.get(),headerToFetch);
    }

    @Test
    public void save(){

        ProfileHeader savedProfileHeader = profileHeaderRepo.save(headerToSave);
        assertSame(savedProfileHeader,headerToSave);
        System.out.println(headerToSave.getId());
    }

}