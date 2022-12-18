package com.travel.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.Profile;
import com.travel.repository.ProfileRepository;
import com.travel.sorting.SortProfileIdFromHighToLow;


@Service

public class ProfileServiceImpl implements ProfileService{
	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
		Profile savedProfile = profileRepository.save(profile);

		return savedProfile;

	}

	@Override
	public List<Profile> getAllProfiless() throws Exception {
		// TODO Auto-generated method stub
		List<Profile> allProfiles = profileRepository.findAll();
		return allProfiles;

	}

	

	@Override
	public List<Profile> getProfileByCity(String city) throws Exception {
		// TODO Auto-generated method stub
		return profileRepository.getProfileByCity(city);
	}

	@Override
	public List<Profile> getProfileByCountry(String country) throws Exception {
		// TODO Auto-generated method stub
		return profileRepository.getProfileByCountry(country);

	}

	@Override
	public List<Profile> getProfileByState(String state) throws Exception {
		// TODO Auto-generated method stub
		return profileRepository.getProfileByState(state);
	}

	@Override
	public List<Profile> getProfileByLandMark(String landMark) throws Exception {
		// TODO Auto-generated method stub
		return profileRepository.getProfileByLandMark(landMark);
	}

	@Override
	public String delete(int profileId) {
		// TODO Auto-generated method stub
		profileRepository.deleteById(profileId);
		return "deleted successfully";
	}

	@Override
	public Profile getProfileByProfileId(int profileId) throws Exception {
		// TODO Auto-generated method stub
		return profileRepository.getProfileByProfileId(profileId);
	}

	@Override
	public List<Profile> getProfileBetweenProfileIds(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return profileRepository.getProfileBetweenProfileIds(range1, range2);
	}

	
	@Override
	public List<Profile> filterByCity(String city) throws Exception {
		// TODO Auto-generated method stub
		List<Profile> allfiltercity=getAllProfiless().stream().filter((profile)->profile.getCity().equals(city)).collect(Collectors.toList());
		return allfiltercity;

	}

	@Override
	public List<Profile> sortByProfileId() throws Exception {
		// TODO Auto-generated method stub
		List<Profile> list = profileRepository.findAll();
		Collections.sort(list, new  SortProfileIdFromHighToLow ());
		return list;
	}

	

}
