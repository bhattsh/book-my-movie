package com.bookyourticket.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookyourticket.profile.entity.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Object> {

}
