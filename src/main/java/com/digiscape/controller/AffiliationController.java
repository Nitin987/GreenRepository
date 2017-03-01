package com.digiscape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiscape.model.Country;
import com.digiscape.model.CountryWiseList;
import com.digiscape.model.GeographicalLocation;
import com.digiscape.model.Organization;
import com.digiscape.service.CountryService;
import com.digiscape.service.GeolocService;
import com.digiscape.service.OrganizationService;

@RestController
@RequestMapping("/Affiliation")
public class AffiliationController {
	@Autowired
	private OrganizationService org;
	@Autowired
	private GeolocService geo;
	@Autowired
	private CountryService cs;
	
	@RequestMapping("/FullTextOrganization/{searchText}")
	public List<Organization> getFullTextOrganization(@PathVariable String searchText){
		
		return org.getFullTextOnOrganization(searchText);
			
	}
	
	@RequestMapping("/FullTextLocation/{searchText}")
	public List<GeographicalLocation> getFullTextLocation(@PathVariable String searchText){
		return geo.getFullTextOnGeolocation(searchText) ;
		
	}
	@RequestMapping("/FullTextCountry/{searchText}")
	public List<Country> getFullTextCountry(@PathVariable String searchText){
		return cs.getFullTextCountry(searchText) ;
		
	}
	@RequestMapping("/FullTextCountryFrench/{searchText}")
	public List<CountryWiseList> getFullTextCountryFrench(@PathVariable String searchText){
		return cs.getFullTextCountryWise(searchText);
		
	}

}
