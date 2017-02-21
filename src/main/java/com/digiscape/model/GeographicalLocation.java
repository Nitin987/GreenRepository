package com.digiscape.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document(collection="GeographicalLocation")
public class GeographicalLocation {
	@Id
	private ObjectId id;
	@TextScore
	Float score;
	private String label;
	@TextIndexed(weight = 2)
	private String city;
	@Indexed(unique = true)
	private String state;
	
	@Field("state-code")
	private String state_code;
	@TextIndexed(weight = 5)
	private String country;
	
	@Field("country-code")
	private String country_code;
	
	@TextIndexed(weight = 3)
	private String postal_code;	
}
