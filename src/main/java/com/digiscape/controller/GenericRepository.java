package com.digiscape.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiscape.model.Author;
import com.digiscape.model.Genus;

import com.digiscape.model.Publisher;
import com.digiscape.model.Species;
import com.digiscape.model.Units;

import com.digiscape.repository.GenusRepository;
import com.digiscape.repository.PublisherRepository;
import com.digiscape.service.AuthorService;
import com.digiscape.service.CountryWiseService;
import com.digiscape.service.GenusSpeciesService;
import com.digiscape.service.GeolocService;
import com.digiscape.service.UnitsService;

@RestController
@RequestMapping("/Genus")
public class GenericRepository {
    @Autowired
	private AuthorService author;
  
    @Autowired
	private GenusSpeciesService genuspe;
       @Autowired
	private GeolocService geo;
    @Autowired
	private UnitsService unit;
    @Autowired
	private CountryWiseService cvs;
    @Autowired
    private PublisherRepository pubRepo;
     @Autowired
    public GenusRepository gen;
		
	@RequestMapping("/startRepository/{path}")
  public void start( String path){
	//initializeXml(path);			
	}	
	@RequestMapping("/Author/TextSearch/{searchText}")
	public List<Author> getListAuthor(@PathVariable String searchText){	
		return author.getFullTextOnAuthor(searchText);
		
	}
	@RequestMapping("/GeoraphyPost/TextSearch/{searchText}")
	public void createGeoloc(@PathVariable String searchText){	
		geo.createCountryRepo(searchText);
		System.out.println("Success");
	}
	@RequestMapping("/Publisher/{searchText}")
	public Publisher getPublisher(@PathVariable String searchText){	
		return pubRepo.findByName(searchText);
		
	}@RequestMapping("/Genus/{searchText}")
	public List<Genus> getGenus(@PathVariable String searchText){	
		System.out.println(gen.findByName(searchText));
		return genuspe.getFullTextGenus(searchText);
		
	}
	@RequestMapping("/Species/{searchText}")
	public List<Species> getSpecies(@PathVariable String searchText){	
		return genuspe.getFullTextSpecies(searchText);
		
	}
	
	@RequestMapping("/SIUnits/{searchText}")
	public List<Units> getUnits(@PathVariable String searchText){	
		return unit.getFullTextUnits(searchText);
		
	}

	@RequestMapping("/FrenchCountry/")
	public void createReposCountry(){
		cvs.insert();
	}

}
