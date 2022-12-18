package com.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.entity.Profile;

@Service
public interface ProfileService {
	public Profile addProfile(Profile profile);

	public List<Profile> getAllProfiless() throws Exception;

	

	public List<Profile> getProfileByCity(String city) throws Exception;

	public List<Profile> getProfileByCountry(String country) throws Exception;

	public List<Profile> getProfileByState(String state) throws Exception;

	public List<Profile> getProfileByLandMark(String landMark) throws Exception;

	public Profile getProfileByProfileId(int profileId) throws Exception;

	public List<Profile> getProfileBetweenProfileIds(int range1, int range2) throws Exception;

	public String delete(int profileId);
	
	
	public List<Profile> sortByProfileId() throws Exception;

		
	public List<Profile>filterByCity(String city)throws Exception;

}
