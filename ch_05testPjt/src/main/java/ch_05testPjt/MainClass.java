package ch_05testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//기존의 방법
		//TransportationWalk transportationWalk = new TransportationWalk();
		//transportationWalk.move();
		
		//spring 이용
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//GenericXmlApplicationContext 클래스 (container) 생성, 생성시 "classpath:xml파일명" 필요
		TransportationWalk transportationWalk = ctx.getBean("tWalk",TransportationWalk.class);
		//getBean을 통한 객체 생성
		transportationWalk.move();
		//똑같이 사용
		
		ctx.close();
		// close 필요
	}
}
