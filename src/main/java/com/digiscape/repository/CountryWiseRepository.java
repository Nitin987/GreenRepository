package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;
import com.digiscape.model.CountryWiseList;

public interface CountryWiseRepository extends CrudRepository<CountryWiseList, String> {

	List <CountryWiseList>findTop5ByOrderByScore(TextCriteria criteria);
}
