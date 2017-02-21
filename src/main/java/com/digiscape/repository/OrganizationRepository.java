package com.digiscape.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;
import com.digiscape.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, String>{
	List<Organization> findTop5ByScore(TextCriteria criteria);
}
