package com.travel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Profile;
import com.travel.service.ProfileService;



@RestController
@RequestMapping("travel/profile")


public class ProfileController {
	@Autowired
	ProfileService profileService;

	public ProfileController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}
	
	private final Logger mylogs = LoggerFactory.getLogger(getClass());
	

	@PostMapping("/addprofile")
	public ResponseEntity<String> addProfile(@RequestBody  Profile profile) {
		try {
			Profile savedProfile = profileService.addProfile(profile);
			String responseMsg = savedProfile.getFullName() + "saved with id" + savedProfile.getProfileId();
			mylogs.info(" ---->> Inside Admin Controller Post mapping , user created "+responseMsg);
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			mylogs.error(errorMsg);
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/landMark/{landMark}")
	public List<Profile> abc5(@PathVariable String landMark) throws Exception {

		return profileService.getProfileByLandMark(landMark);
	}

	@GetMapping("/city/{city}")
	public List<Profile> abc2(@PathVariable String city) throws Exception {

		return profileService.getProfileByCity(city);
	}

	@GetMapping("/country/{country}")
	public List<Profile> abc3(@PathVariable String country) throws Exception {

		return profileService.getProfileByCountry(country);
	}

	@GetMapping("/state/{state}")
	public List<Profile> abc4(@PathVariable String state) throws Exception {

		return profileService.getProfileByState(state);
	}

	@GetMapping("profileid/{searchprofileId}")
	public Profile abc6(@PathVariable int searchprofileId) throws Exception {
		return profileService.getProfileByProfileId(searchprofileId);
	}

	@GetMapping("/profilebetweenId")
	public List<Profile> profileById(@RequestParam int r1, @RequestParam int r2) throws Exception {

		return profileService.getProfileBetweenProfileIds(r1, r2);
	}

	@GetMapping("/profiles")
	public List<Profile> getAllProfiles() {
		try {
			List<Profile> allExtractedProfiles = profileService.getAllProfiless();

			return allExtractedProfiles;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;

	}
	@GetMapping("/filterbyCity/{city}")
	public List<Profile> filtercity(@PathVariable String city) throws Exception
	{
		List<Profile> filtered = profileService.filterByCity(city);
		return filtered;
	}
	
	@GetMapping("/profileId")
	public List<Profile> sortByProfileId() throws Exception {
		return profileService.sortByProfileId();
	}

	@PutMapping("/updateprofileid/{profileId}")
	public Profile updateProfile(@PathVariable int profileId, @RequestBody Profile profiles) throws Exception {
		profileService.getProfileByProfileId(profileId);
		profiles.setProfileId(profileId);
		Profile updateProfile = profileService.addProfile(profiles);
		return updateProfile;
	}

	@DeleteMapping("/deleteprofileid/{searchprofileId}")
	public String deleteUser(@PathVariable int searchprofileId) {
		try {
			profileService.delete(searchprofileId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleted successfully";
	}
	
	

}
