package com.digiscape.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;

@Document(collection="Grant")
@Data
public class GrantSponsor {
	@Id
	private ObjectId id;
	@TextIndexed(weight=4)
	private String grantSponsors;
	@TextScore
	Float score;

}
