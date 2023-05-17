package test0517;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Project {
	@Autowired
	private ArticleDao articleDao;

	public void test() throws Exception{
		System.out.println("프로젝트 테스트 시작");
		articleDao.insert(articleDao + " : insert() 메서드 실행됨");
		articleDao.update(articleDao + " : update() 메서드 실행됨");
		articleDao.delete(articleDao + " : delete() 메서드 실행됨");
	}
}
