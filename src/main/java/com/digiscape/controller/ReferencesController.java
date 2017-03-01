package com.digiscape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digiscape.model.Artifact;
import com.digiscape.model.Artifact_Book;
import com.digiscape.service.ReferenceServices;

@RestController
@RequestMapping("/References")
public class ReferencesController {
	
	@Autowired
	private ReferenceServices rs;
	@RequestMapping("/JRefrences/{search}")
	public List<Artifact> getJReferences(@PathVariable String search){
		return rs.getFullTextOnArtifact(search);
		
		
		
	}
	@RequestMapping("/BRefrences/{search}")
	public List<Artifact_Book> getBReferences(@PathVariable String search){
		return rs.getFullTextOnArtifactBook(search);
		
		
		
	}
}
