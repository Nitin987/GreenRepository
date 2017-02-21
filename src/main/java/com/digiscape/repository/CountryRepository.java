package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Country;


public interface CountryRepository extends CrudRepository<Country, String>{
	List <Country>findTop5ByScore(TextCriteria criteria);
}