package com.digiscape.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.CrudRepository;

import com.digiscape.model.Organization;
@ConfigurationProperties(prefix="spring.data_Machine.mongodb.database")
public interface OrganizationRepository extends CrudRepository<Organization, String>{
	List<Organization> findTop5ByOrderByScoreDesc(TextCriteria criteria);
	Organization findByName(String search);
}
