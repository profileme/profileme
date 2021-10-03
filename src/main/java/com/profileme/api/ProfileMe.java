package com.profileme.api;

import com.profileme.entity.ProfileHeader;
import com.profileme.service.ProfileHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profileme")
public class ProfileMe {

    @Autowired
    private ProfileHeaderService profileHeaderService;

    @PostMapping("/header")
    public ProfileHeader saveProfileHeader(@RequestBody ProfileHeader profileHeader) { // saving header information about profile

        return profileHeaderService.saveProfileHeader(profileHeader);
    }
}

