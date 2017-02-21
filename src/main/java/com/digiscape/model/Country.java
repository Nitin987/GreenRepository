package com.digiscape.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;

@Document(collection ="Country")
@Data
public class Country {
	@Id
	private ObjectId id;
	@Field("countryName")
	@TextIndexed(weight = 4)private String countryName;
	@Field("twolettercountryCode")
	private String twolettercountryCode;
	@Field("threelettercountryCode")
	private String threelettercountryCode;
	@Field("city")
	@TextIndexed(weight = 3)private List<City> city;
	@TextScore
	Float score;

}
