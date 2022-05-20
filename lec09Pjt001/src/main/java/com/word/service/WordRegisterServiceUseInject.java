package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseInject {

	@Inject // @Inject: required속성 없다
	// required속성은 거의 안쓰이므로 사실상 @Autowired랑 동일
	// 자주 쓰이는건 @Autowired
	@Named(value="wordDao1")
	// @Autowired: @Qualifier(별도의 Qualifier 선언) @Inject: @Named(id명)
	// 같은 기능
	private WordDao wordDao;
	
	public WordRegisterServiceUseInject() {
		
	}
	
//	@Inject
	public WordRegisterServiceUseInject(WordDao wordDao) {
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
	
//	@Inject
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
