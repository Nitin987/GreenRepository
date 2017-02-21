package com.digiscape.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.GeographicalLocation;
import com.digiscape.repository.GeolocationRepository;
@Service
public class GeolocService {
	@Autowired
	private GeolocationRepository geoRepo;
	GeographicalLocation org=new GeographicalLocation();
	public List<GeographicalLocation> getAllGeolocation(){
		List<GeographicalLocation> GeolocationList=new ArrayList<>();
		geoRepo.findAll().forEach(GeolocationList::add);
		
		return GeolocationList;
		
	}
	public GeographicalLocation getGeolocation(String search){
		
		return geoRepo.findOne(search);
	}
	public GeographicalLocation createGeolocation(){
		
		return geoRepo.save(org);
	}
	
	public List<GeographicalLocation> getFullTextOnGeolocation(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingPhrase(search);
		
		return geoRepo.findTop5ByScore(criteria);
		
	}

}
