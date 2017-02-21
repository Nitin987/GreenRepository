package com.digiscape.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.Data;
@Data
public class Units {
@Id ObjectId id;
@TextIndexed(weight=5) private String SIUnitFull;
@TextIndexed(weight=3) private String SIUnitAbbr;
@TextScore Float score;
}
