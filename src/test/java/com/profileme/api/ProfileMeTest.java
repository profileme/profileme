package com.profileme.api;

import com.profileme.entity.ProfileHeader;
import com.profileme.service.ProfileHeaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebMvcTest
class ProfileMeTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
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

        Mockito.when(profileHeaderService.saveProfileHeader(header)).thenReturn(header);

        Mockito.when(profileHeaderService.getProfileHeaderById(1L)).thenReturn(java.util.Optional.ofNullable(header));
    }

    @Test
    void saveProfileHeader() {

        try {
    mockMvc.perform(MockMvcRequestBuilders.post("/profileme/header").contentType(MediaType.APPLICATION_JSON).content("{\n" +
            "\t\"name\":\"Anas Ibraheem\",\n" +
            "    \"birthDate\": \"1983-06-22\",\n" +
            "\t\"country\":\"jordan\",\n" +
            "\t\"region\":\"south\",\n" +
            "\t\"city\":\"karak\",\n" +
            "\t\"street\":\"mulukee\",\n" +
            "\t\"email\":\"anas@gmail.com\",\n" +
            "\t\"mobile\":\"079888\",\n" +
            "\t\"gender\":\"male\"\t\n" +
            "}")).andExpect(MockMvcResultMatchers.status().isOk());

} catch(Exception e){
    e.printStackTrace();
}
    }

    @Test
    public void getProfileHeaderById(){

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/profileme/header").contentType(MediaType.APPLICATION_JSON).pathInfo("1"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}