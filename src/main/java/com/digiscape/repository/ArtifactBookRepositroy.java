package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Artifact_Book;


public interface ArtifactBookRepositroy extends CrudRepository<Artifact_Book, String>{
	List <Artifact_Book>findTop5ByOrderByScore(TextCriteria criteria);
}
