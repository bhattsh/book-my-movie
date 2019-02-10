package com.bookyourticket.profile.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookyourticket.profile.entity.Address;
import com.bookyourticket.profile.entity.Profile;
import com.bookyourticket.profile.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	
	@Autowired
	ProfileService service;

	@Test
	public void testForGetAllProfiles() { // fail("Not yet implemented");
		List<Profile> getAllProfilesObject = service.getAllProfile();
		System.out.println(getAllProfilesObject);
		assertEquals(0, getAllProfilesObject.size());
	}

	@Test
	public void testForGetProfileById() {
		Optional<Profile> getProfileByIdObject = service.getProfileById(101);
		assertEquals(false, getProfileByIdObject.isPresent());
	}

	@Test
	public void testForGetProfileByIdWhichIsNotPresent() {
		Optional<Profile> getProfileById = service.getProfileById(1);
		assertEquals(true, getProfileById.isPresent());
	}

	@Test
	public void testForDelete() {
		service.deleteProfileById(101);
		Optional<Profile> getProfileByIdObject = service.getProfileById(1);
		assertEquals(false, getProfileByIdObject.isPresent());

	}

	@Test
	public void testForDeleteAndCheckSize() {
		List<Profile> getProfileByIdObject = service.getAllProfile();
		service.deleteProfileById(101);
		assertEquals(0, getProfileByIdObject.size());
	}

	@Test
	public void testForAddingAccount() {

		Profile profile = new Profile(101, "Srivani", "srivani@gmail.com", "7894561230",
				new Address("900", "Ramnagar", "Karimnagar", "Telangana", "India"), "F");
		Profile profiles = service.addProfile(profile);
		assertEquals(profile, profiles);

	}
	
	@Test
	public void testForUpdate() {
		Profile profile=new Profile(101, "Srivani", "kunni@gmail.com", "7894561230",
				new Address("900", "Ramnagar", "Karimnagar", "Telangana", "India"),"M");

		profile.setEmailId("kunni@gmail.com");
		profile.setGender("M");
		Profile profiles = service.updateProfile(profile);
		assertEquals(profile, profiles);

	}
}
