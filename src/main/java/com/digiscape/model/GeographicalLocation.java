package com.digiscape.model;

import lombok.Data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document(collection="geoloc")
@Data
public class GeographicalLocation {
	@Id
	private ObjectId id;
	@TextScore
	Float score;
	private String label;
	
	private String city;
	
	private String state;
	
	@Field("state-code")
	private String state_code;

	private String country;
	
	@Field("country-code")
	private String country_code;
	private String postal_code;	
}
