package com.profileme.service;

import com.profileme.entity.ProfileHeader;
import com.profileme.repo.ProfileHeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileHeaderService {
    @Autowired
    ProfileHeaderRepo profileHeaderRepo;

    public Optional<ProfileHeader> getProfileHeaderById(Long id) {
        return profileHeaderRepo.findById(id);
    }

    public ProfileHeader saveProfileHeader(ProfileHeader profileHeader) {
        return profileHeaderRepo.save(profileHeader);
    }
}
