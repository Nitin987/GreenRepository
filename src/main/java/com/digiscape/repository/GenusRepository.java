package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;
import com.digiscape.model.Genus;

public interface GenusRepository extends CrudRepository<Genus, String>{
	List <Genus>findTop5ByScore(TextCriteria criteria);
}
