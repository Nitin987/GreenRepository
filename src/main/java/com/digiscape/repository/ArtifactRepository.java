package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Artifact;
import com.digiscape.model.Country;

public interface ArtifactRepository extends CrudRepository<Artifact, String>{
	List <Artifact>findTop5ByOrderByScore(TextCriteria criteria);
}
