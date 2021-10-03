package com.profileme.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    /*private Date birthDate;
    private String country;
    private String region;
    private String city;
    private String street;
    private String email;
    private String mobile;
    private String gender;
    private String maritialStatus;
    private String nationality;*/
}
