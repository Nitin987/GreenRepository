package com.digiscape.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;
@Data
@Document(collection="genus_data")
public class Genus {
	@Id
	private ObjectId _id;
	private String name;
	  private String type;
	  @TextScore
	  Float score;

}
