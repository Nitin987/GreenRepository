package com.digiscape.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.digiscape.model.Author;
import com.digiscape.repository.AuthorReposiory;
@Service
public class AuthorService {
	@Autowired
	private AuthorReposiory author;
	Author au=new Author();
	public List<Author> getAllAuthor(){
		List<Author> authorList=new ArrayList<>();
		author.findAll().forEach(authorList::add);
		
		return authorList;
		
	}
	public Author getAuthor(String search){
		
		return author.findOne(search);
	}
	public Author createAuthor(){
		
		return author.save(au);
	}
	
	public List<Author> getFullTextOnAuthor(String search){
		TextCriteria criteria=TextCriteria.forDefaultLanguage().matchingPhrase(search);
		
		return author.findAllByOrderByScoreDesc(criteria);
		
	}

}
