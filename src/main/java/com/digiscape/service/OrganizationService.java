package com.digiscape.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.Organization;
import com.digiscape.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository orgRepo;
	Organization org=new Organization();
	public List<Organization> getAllOrganization(){
		List<Organization> OrganizationList=new ArrayList<>();
		orgRepo.findAll().forEach(OrganizationList::add);
		
		return OrganizationList;
		
	}
	public Organization getOrganization(String search){
		
		return orgRepo.findByName(search);
	}
	public Organization createOrganization(){
		
		return orgRepo.save(org);
	}
	
	public List<Organization> getFullTextOnOrganization(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingPhrase(search);
		
		return orgRepo.findAllByOrderByScoreDesc(criteria);
		
	}

}
