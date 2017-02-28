package com.digiscape.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Country;

@ConfigurationProperties(prefix="spring.data_Machine.mongodb.database")
public interface CountryRepository extends CrudRepository<Country, String>{
	List <Country>findTop5ByOrderByScore(TextCriteria criteria);
	List<Country>findTop5BycountryName(TextCriteria criteria);
}
