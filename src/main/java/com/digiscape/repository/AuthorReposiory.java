package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Author;
import com.digiscape.model.Country;

public interface AuthorReposiory extends CrudRepository<Author, String> {
	List <Author>findTop5ByScore(TextCriteria criteria);
}
