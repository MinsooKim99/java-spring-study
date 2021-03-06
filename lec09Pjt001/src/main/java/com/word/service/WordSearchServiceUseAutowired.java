package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseAutowired {
	
	@Autowired
//	@Qualifier("usedDao") // 동일객체 여러개 생성시
	// 1. (주로사용)Qualifier값을 만들어 사용 2.bean의 이름과 property의 이름을 똑같게
	private WordDao wordDao;
	
	public WordSearchServiceUseAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordSearchServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
