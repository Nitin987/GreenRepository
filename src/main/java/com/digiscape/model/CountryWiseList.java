package com.digiscape.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;
@Document(collection="CountryWiseList")
@Data
public class CountryWiseList {
	private String englishCountryNames;
	private String allowedEnglishsynonyms;
	private String frenchCountrynames;
	
	@TextScore
	Float score;

}
