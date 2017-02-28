package com.digiscape.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.GeographicalLocation;
import com.digiscape.model.Organization;
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
public List<GeographicalLocation> getState(String search){
		System.out.println(geoRepo.findByState(search));
		return geoRepo.findByState(search);
	}


	public GeographicalLocation createGeolocation(){
		
		return geoRepo.save(org);
	}
	
	public List<GeographicalLocation> getFullTextOnGeolocation(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matching(search);
		
		return geoRepo.findTop5ByOrderByScore(criteria);
		
	}
	public List<GeographicalLocation> getCountryname(String search){
		
		return geoRepo.findTop5Bycountry(search);
		
	}
	public void createCountryRepo(String path){
		String csvFile = "C:\\Users\\74461\\Desktop\\USStates.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                 
                	  if(country[2]!=null&&!country[2].isEmpty()){
                		  GeographicalLocation org=new GeographicalLocation();
                		  org.setState(country[1]);
                		  org.setState_code(country[2]);
                	  geoRepo.save(org);
                	 
                	  
            }
                  }

        } catch (IOException e) {
            e.printStackTrace();
        }

		
		
	}

}
