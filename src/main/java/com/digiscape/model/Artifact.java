package com.digiscape.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;

@Document(collection = "artifact")
@Data
public class Artifact {
	@Id
	private ObjectId id;
	@TextIndexed(weight=3)
	private String articleTitle;
	@TextIndexed(weight=5)
	@Field("journalTitle")
	private String journalTitle;
	
	@Field("language")
	private String language;
	
	@Field("alt-language")
	private String alt_language;
	
	@Field("url")
	private String url;
	
	@TextScore Float score;
	
	@Field("pii")
	private String pii;
	@TextIndexed(weight=4)
	@Field("doi")
	private String doi;
	
	@Field("volume")
	private String volume;
	
	@Field("issue")
	private String issue;
	@TextIndexed(weight=2)
	@Field("first-page")
	private String firstPage;
	
	@Field("last-page")
	private String lastPage;
	@Field("type")
	private String type;
	
	@Field("year")
	private String year;
	
	@Field("issn")
	private String issn;
	
	@Field("createddate")
	private Date createddate;
	
	@Field("updateddate")
	private Date updateddate;
}
