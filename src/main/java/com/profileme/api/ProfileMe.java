package com.profileme.api;

import com.profileme.entity.ProfileHeader;
import com.profileme.error.ApiError;
import com.profileme.service.ProfileHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/profileme")
public class ProfileMe {

    @Autowired
    private ProfileHeaderService profileHeaderService;

    @PostMapping("/header")
    public ProfileHeader saveProfileHeader(@Valid @RequestBody ProfileHeader profileHeader) { // saving header information about profile

        return profileHeaderService.saveProfileHeader(profileHeader);
    }

    @GetMapping("/header/{id}")
    public Optional<ProfileHeader> getProfileHeaderById(@PathVariable Long id) throws ApiError {

        Optional<ProfileHeader> profileHeaderById = profileHeaderService.getProfileHeaderById(id);
        if(!profileHeaderById.isPresent()) throw new ApiError(HttpStatus.NOT_FOUND,"Resource cant be found");
        return profileHeaderById;

    }
}

