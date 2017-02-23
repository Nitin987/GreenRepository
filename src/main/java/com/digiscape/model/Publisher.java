package com.digiscape.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;

@Document(collection="Publisher")
@Data
public class Publisher {
	@Id
	private ObjectId id;
	@Field("publisherAbr")
	private List<String>publisherAbr;
	
	private String name;

	private String address;
	
	@Field("publicationDate")
	private CustomDate publicationDate;
	@TextScore
	Float score;
	
}
