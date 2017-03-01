package com.digiscape.repository;

import java.util.List;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Units;

public interface UnitsRepository extends CrudRepository<Units, String> {
	List <Units>findTop5ByOrderByScore(TextCriteria criteria);
}
