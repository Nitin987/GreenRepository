package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.GeographicalLocation;

public interface GeolocationRepository extends CrudRepository<GeographicalLocation, String> {
	List <GeographicalLocation>findTop5ByScore(TextCriteria criteria);
}
