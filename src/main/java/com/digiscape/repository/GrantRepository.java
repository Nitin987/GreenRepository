package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;
import com.digiscape.model.GrantSponsor;

public interface GrantRepository extends CrudRepository<GrantSponsor, String> {
	List <GrantSponsor>findTop5ByScore(TextCriteria criteria);
}
