package com.profileme.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.profileme.entity.ProfileHeader;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileHeaderRepo extends JpaRepository<ProfileHeader,Long> {

}
