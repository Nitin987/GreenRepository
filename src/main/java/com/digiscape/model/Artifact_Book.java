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

@Document(collection = "artifactBook")
@Data
public class Artifact_Book {
	@Id
	private ObjectId id;
	private String chapterTitle;
	@Field("book-title")
	private String bookTitle;
	
	@Field("edited-book-title")
	private String editedBookTitle;
	
	@Field("language")
	private String language;
	
	@Field("alt-language")
	private String alt_language;
	@TextIndexed(weight = 2)
	@Field("publisher-name")
	private String publisherName;
	
	@Field("publisher-location")
	private String publisherLocation;
	
	@TextScore Float score;
	
	@Field("pii")
	private String pii;
	@Field("doi")
	private String doi;
	
	@Field("volume")
	private String volume;
	
	@Field("issue")
	private String issue;
	
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
	
	@Field("isbn")
	private String isbn;
	
	@Field("edition")
	private String edition;
	
	@Field("chapters")
	private List<Chapter> chapters;

	@Field("createddate")
	private Date createddate;
	
	@Field("updateddate")
	private Date updateddate;
}
