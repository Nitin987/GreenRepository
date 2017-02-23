package com.digiscape.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Species;
@ConfigurationProperties(prefix="spring.data_Genus.mongodb.database")
public interface SpeciesRepository extends CrudRepository<Species, String>{
	List <Species>findTop5ByScore(TextCriteria criteria);
	Species findByName(String search);
}
