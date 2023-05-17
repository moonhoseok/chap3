package xml;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class ArticleCacheAdvice {
	// cache = {1, new Article(1) }
	private Map<Integer, Article> cache = new HashMap<Integer,Article>();
	
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[ACA] cache before 실행");
		//joinPoint.getArgs() : 핵심메서드의 매겨변수목록
		Integer id = (Integer)joinPoint.getArgs()[0]; // 1
		Article article = cache.get(id); // null
		if(article != null) { // 실행안됨
			System.out.println("[ACA] cache에서 Article["+id+"] 가져옴");
			return article;
		}
		//ret : 핵심메서드의 리턴값. new Article(1)
		Object ret = joinPoint.proceed(); // 다음메서드 호출(LoggingAdvice.before())
		System.out.println("[ACA] cache after 실행");
		if(ret != null && ret instanceof Article) {
			cache.put(id, (Article)ret);
			System.out.println("[ACA] cache에서 Article["+id+"] 추가함");
		}
		return ret;
	}
}
