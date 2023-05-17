package test0516;

import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
        new GenericXmlApplicationContext("classpath:applicationContext.xml");
	    WriteArticleService articleService = 
	    		ctx.getBean("writeArticleService",WriteArticleService.class);
	    articleService.write(new Article());
	}
}