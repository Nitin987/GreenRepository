package com.digiscape.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;


@Document(collection = "organization")
@Data
public class Organization {
	@Id
	private ObjectId id;
	@TextIndexed(weight = 3) private String name;
	private List<DivisionName> division_name;
	private String abbrev_name;
	private String tel;
	private String fax;
	@TextScore
	Float score;
}

