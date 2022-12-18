package com.travel.sorting;

import java.util.Comparator;

import com.travel.entity.Profile;

public class SortProfileIdFromHighToLow implements Comparator<Profile>{
	@Override
	public int compare(Profile o1, Profile o2) {
		// TODO Auto-generated method stub
		return o2.getProfileId()-o1.getProfileId();
	}

}
