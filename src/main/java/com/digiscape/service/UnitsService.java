package com.digiscape.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.Genus;
import com.digiscape.model.Units;
import com.digiscape.repository.UnitsRepository;
@Service
public class UnitsService {
@Autowired
UnitsRepository unit;
Units un=new Units();

public Units getUnit(String search){
	
	return unit.findOne( search);
}

public List<Units> getAllUnits(){
	List<Units> unitList=new ArrayList<>();
	unit.findAll().forEach(unitList::add);
	
	return unitList;
	
}
public List<Units> getFullTextUnits(String search){
	TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingAny(search);
	
	return unit.findTop5ByScore(criteria);
	
}





}
