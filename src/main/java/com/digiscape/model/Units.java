package com.digiscape.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;
@Data
@Document(collection="Units")
public class Units {
@Id ObjectId id;
 private String SIUnitFull;
private String SIUnitAbbr;
@TextScore Float score;
}
