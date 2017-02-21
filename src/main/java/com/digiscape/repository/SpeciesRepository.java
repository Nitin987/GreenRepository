package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;
import com.digiscape.model.Species;

public interface SpeciesRepository extends CrudRepository<Species, String>{
	List <Species>findTop5ByScore(TextCriteria criteria);
	Species findByName();
}
