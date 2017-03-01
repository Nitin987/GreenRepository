package com.digiscape.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.Country;
import com.digiscape.model.CountryWiseList;
import com.digiscape.repository.CountryRepository;
import com.digiscape.repository.CountryWiseRepository;
@Service
public class CountryService {
@Autowired
CountryRepository country;
@Autowired
CountryWiseRepository countrywise;
Country cc=new Country();
	public Country getCountryName(String search){
		return country.findOne(search);
		
	}
	public List<Country> getAllCountry(){
		List<Country> countryList=new ArrayList<>();
		country.findAll().forEach(countryList::add);
		
		return countryList;
		
	}
public Country createGeolocation(){
		
		return country.save(cc);
	}
	public List<Country> getFullTextCountry(String search){
			//TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingAny(search);
			
			return country.findTop5BycountryName(search);
			
		}
	
	public List<CountryWiseList> getFullTextCountryWise(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingAny(search);
		
		return countrywise.findTop5ByOrderByScore(criteria);
		
	}
	
	
	public List<Country> getBycountryName(String search){
		//TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingAny(search);	
		if(search.contains(",")){
		String []splitterm=search.split(",");
		
		for(int i=splitterm.length-1;i>0;i++){
			
			return country.findTop5BycountryName(splitterm[i]);
		
		}
		}
		return country.findTop5BycountryName(search);
		
	}
}
