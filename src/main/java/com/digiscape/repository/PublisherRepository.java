package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;
import com.digiscape.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, String>{
	List <Publisher>findTop5ByScore(TextCriteria criteria);
	Publisher findByName(String search);
}
