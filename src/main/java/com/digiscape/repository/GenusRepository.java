package com.digiscape.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Genus;
@ConfigurationProperties(prefix="spring.data_Genus.mongodb.database")
public interface GenusRepository extends CrudRepository<Genus, String>{
	List <Genus>findAllByOrderByScoreDesc(TextCriteria criteria);
    Genus findByName(String search);
}
