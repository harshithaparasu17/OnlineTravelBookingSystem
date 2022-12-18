package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.Profile;

@Repository

public interface IProfileCustomRepository {
	@Query("from Profile where profileId >= :range1 and profileId <= :range2")
	public List<Profile> getProfileBetweenProfileIds(@Param("range1") int range1, @Param("range2") int range2)
			throws Exception;

	public Profile getProfileByFullName(String fullName) throws Exception;

	public List<Profile> getProfileByCity(String city) throws Exception;

	public List<Profile> getProfileByCountry(String country) throws Exception;

	public List<Profile> getProfileByState(String state) throws Exception;

	public List<Profile> getProfileByLandMark(String landMark) throws Exception;

	public Profile getProfileByProfileId(int profileId) throws Exception;
}
