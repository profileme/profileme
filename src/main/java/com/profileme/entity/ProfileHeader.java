package com.profileme.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "please provide a name")
    private String name;
    @Past
    private Date birthDate;
    private String country;
    private String region;
    private String city;
    private String street;
    private String email;
    private String mobile;
    private String gender;
    private String maritialStatus;
    private String nationality;
}
