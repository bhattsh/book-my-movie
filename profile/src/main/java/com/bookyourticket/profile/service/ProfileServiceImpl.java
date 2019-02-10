package com.bookyourticket.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyourticket.profile.entity.Profile;
import com.bookyourticket.profile.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository repository;


	@Override
	public Optional<Profile> getProfileById(int profileId) {

		return repository.findById(profileId);
	}

	@Override
	public List<Profile> getAllProfile() {

		return repository.findAll();

	}

	@Override
	public void deleteProfileById(int profileId) {

		repository.deleteById(profileId);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		
		return repository.save(profile);
	}

	@Override
	public Profile addProfile(Profile profile) {
		return repository.save(profile);		
	}

}
