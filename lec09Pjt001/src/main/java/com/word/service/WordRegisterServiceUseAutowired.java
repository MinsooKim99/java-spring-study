package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseAutowired {
	// @Autowired를 통한 의존객체 자동주입
	@Autowired
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	// method나 property에 anotation(@Autowired,@Resource,@Inject 등)을 사용하려면
	// 디폴트 생성자가 있어야 한다.
	// @Resource(이름 확인)는 method나 property에 사용할 수 있지만 생성자에 쓰지 못한다.
	public WordRegisterServiceUseAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
