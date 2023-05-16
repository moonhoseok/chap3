package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.WriteImpl;

public class Main1 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aop.xml");
		WriteImpl bean = ctx.getBean("write",WriteImpl.class);
		bean.write();
	}
}
