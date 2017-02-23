package com.digiscape.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Units;
@ConfigurationProperties(prefix="spring.data_Genus.mongodb.database")
public interface UnitsRepository extends CrudRepository<Units, String> {
	List <Units>findTop5ByScore(TextCriteria criteria);
}
