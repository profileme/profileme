package com.profileme.service;

import com.profileme.entity.ProfileHeader;
import com.profileme.repo.ProfileHeaderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileHeaderServiceTest {

    @MockBean
    private ProfileHeaderRepo profileHeaderRepo;

    @Autowired
    private ProfileHeaderService profileHeaderService;

    ProfileHeader header;

    @BeforeEach
    void setUp() {

        try {
            header=ProfileHeader.builder().birthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1983-06-22"))
                    .name("Anas Ibraheem").country("jordan").city("karak").email("anas.alsarairah@gmail.com").maritialStatus("single")
                    .nationality("jordanian").mobile("0797289609").id(1L).build();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Mockito.when(profileHeaderRepo.findById(1L)).thenReturn(java.util.Optional.ofNullable(header));
        Mockito.when(profileHeaderRepo.save(header)).thenReturn(header);
    }

    @Test
    void getProfileHeaderById() {
        Optional<ProfileHeader> profileHeaderById = profileHeaderService.getProfileHeaderById(1L);
        assertSame(profileHeaderById.get(),header);
    }

    @Test
    void saveProfileHeader() {
        ProfileHeader profileHeader = profileHeaderService.saveProfileHeader(header);
        assertSame(profileHeader,header);
    }
}