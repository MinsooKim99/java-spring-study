package ch_05testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

// 프로젝트를 폴더로 만들어서 import해서 사용하기
public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk transportationWalk = ctx.getBean("tWalk",TransportationWalk.class);
		transportationWalk.move();
		
		ctx.close();
	}
}
