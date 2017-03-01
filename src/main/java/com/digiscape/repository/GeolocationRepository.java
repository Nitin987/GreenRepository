package com.digiscape.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.GeographicalLocation;

public interface GeolocationRepository extends CrudRepository<GeographicalLocation, String> {
	List <GeographicalLocation>findTop5ByOrderByScore(TextCriteria criteria);
	List<GeographicalLocation> findTop5ByOrderByCountry(String Search);
	List<GeographicalLocation> findByState(String Search);
	List <GeographicalLocation>findTop5Bycountry(String search);}