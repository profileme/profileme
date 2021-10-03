package com.profileme.service;

import com.profileme.entity.ProfileHeader;
import com.profileme.repo.ProfileHeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileHeaderService {
    @Autowired
    ProfileHeaderRepo profileHeaderRepo;

    public ProfileHeader saveProfileHeader(ProfileHeader profileHeader) {

        return profileHeaderRepo.save(profileHeader);
    }
}
