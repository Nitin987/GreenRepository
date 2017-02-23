package com.digiscape.model;

import java.util.List;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;

@Document(collection = "Authors")
@Data
public class Author {

	@Field("initial")
	private String initials;
	@Field("Degree")
	private List<String> degrees;
	@Field("prefix")
	private String prefix;

	@Field("corresp_author")
	private Boolean correspAuthor;

	@Field("given-name")
	private String given_name;
	
	@Field("family-name")
	private String family_name;

	@Field("alt-name")
	private String alt_name;

	@Field("suffix")
	private String suffix;

	@Field("fullName")
	private String fullName;

	@Field("orcid")
	private String orcid;

	@Field("email")
	private String email;

	@Field("url")
	private String url;
	private Address address;
	@TextScore
	Float score;
}
