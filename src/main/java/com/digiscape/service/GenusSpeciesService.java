package com.digiscape.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.Genus;
import com.digiscape.model.Species;
import com.digiscape.model.Genus;
import com.digiscape.repository.GenusRepository;
import com.digiscape.repository.SpeciesRepository;
import com.digiscape.repository.GenusRepository;
@Service
public class GenusSpeciesService {
	
	@Autowired
	GenusRepository genus;
	@Autowired
	SpeciesRepository species;
	Species sp=new Species();
	Genus gg=new Genus();
		public Genus getGenusName(String search){
			return genus.findByName(search);
			
		}
		
		public Species getSpeciesname(String search){
			
			return species.findByName(search);
		}
		public List<Genus> getAllGenus(){
			List<Genus> GenusList=new ArrayList<>();
			genus.findAll().forEach(GenusList::add);
			
			return GenusList;
			
		}
	public Genus createGeolocation(){
			
			return genus.save(gg);
		}
		public List<Genus> getFullTextGenus(String search){
				TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingPhrase(search);
				
				return genus.findAllByOrderByScoreDesc(criteria);
				
			}
			
		public List<Species> getFullTextSpecies(String search){
			TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingPhrase(search);
			
			return species.findTop5ByScore(criteria);
			
		}
		
}
