package com.digiscape.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiscape.model.Author;
import com.digiscape.model.Genus;
import com.digiscape.model.GeographicalLocation;
import com.digiscape.model.Organization;
import com.digiscape.model.Publisher;
import com.digiscape.model.Species;
import com.digiscape.model.Units;
import com.digiscape.repository.PublisherRepository;
import com.digiscape.service.AuthorService;
import com.digiscape.service.CountryService;
import com.digiscape.service.GenusSpeciesService;
import com.digiscape.service.GeolocService;
import com.digiscape.service.OrganizationService;
import com.digiscape.service.UnitService;

@RestController
@ComponentScan("com.digiscape.service")

public class Repository {
    @Autowired
	private AuthorService author;
    @Autowired
	private OrganizationService org;
    @Autowired
	private GenusSpeciesService genuspe;
    @Autowired
	private CountryService country;
    @Autowired
	private GeolocService geo;
    @Autowired
	private UnitService unit;
    @Autowired
    private PublisherRepository pubRepo;
     
	@RequestMapping("/startRepository/{path}")
  public void start( String path){
	//initializeXml(path);			
	}	
	@RequestMapping("/Author/TextSearch/{searchText}")
	public List<Author> getListAuthor(@PathVariable String searchText){	
		return author.getFullTextOnAuthor(searchText);
		
	}
	@RequestMapping("/Organization/TextSearch/{Name}")
	public List<Organization> getListOrganization(@PathVariable String searchText){	
		return org.getFullTextOnOrganization(searchText);
		
	}@RequestMapping("/Publisher/{searchText}")
	public Publisher getPublisher(@PathVariable String searchText){	
		return pubRepo.findByName(searchText);
		
	}@RequestMapping("/Genus/{searchText}")
	public List<Genus> getGenus(@PathVariable String searchText){	
		return genuspe.getFullTextGenus(searchText);
		
	}
	@RequestMapping("/Species/{searchText}")
	public List<Species> getSpecies(@PathVariable String searchText){	
		return genuspe.getFullTextSpecies(searchText);
		
	}
		
	@RequestMapping("/Location/TextSearch/{searchText}")
	public List<GeographicalLocation> getLocation(@PathVariable String searchText){	
		return geo.getFullTextOnGeolocation(searchText) ;
		
	}
	@RequestMapping("/SIUnits/{searchText}")
	public List<Units> getUnits(@PathVariable String searchText){	
		return unit.getFullTextUnits(searchText);
		
	}

}