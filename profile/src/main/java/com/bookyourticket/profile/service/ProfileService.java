package com.bookyourticket.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookyourticket.profile.entity.Profile;

@Service
public interface ProfileService {

	Optional<Profile> getProfileById(int profileId);

	List<Profile> getAllProfile();

	void deleteProfileById(int profileId);

	Profile addProfile(Profile profile);
	
	Profile updateProfile(Profile profile);

	

}

