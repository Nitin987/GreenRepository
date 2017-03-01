package com.digiscape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.Artifact;
import com.digiscape.model.Artifact_Book;
import com.digiscape.repository.ArtifactBookRepositroy;
import com.digiscape.repository.ArtifactRepository;
@Service
public class ReferenceServices {

	@Autowired
	private ArtifactRepository ar;
	@Autowired
	private ArtifactBookRepositroy ab;
	
	public List<Artifact> getFullTextOnArtifact(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingAny(search);
		
		return ar.findTop5ByOrderByScore(criteria);
		
	}

	
	public List<Artifact_Book> getFullTextOnArtifactBook(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingAny(search);
		
		return ab.findTop5ByOrderByScore(criteria);
		
	}

	
	
}
