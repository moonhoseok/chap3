package annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component	// 객체화
@Aspect		// AOP 클래스.
@Order(3)	// 순서지정
public class LoggingAspect {
	// "execution(public * annotation..*(..))" : 어노테이션에 속한 클래스의 퍼블릭 메서드들을 포인트컷으로 설정
	// pointcut 설정 : annotation 패키지에 속한 클래스의 모든 public 메서드
	final String publicMethod = "execution(public * annotation..*(..))";
	@Before(publicMethod) 
	public void before() {
		System.out.println("[LA] Before 메서드 실행 전 실행 : Before");
	}
	@AfterReturning(pointcut=publicMethod, returning="ret")
	public void afterReturning(Object ret) { //ret : 핵심메서드의 리턴값
		System.out.println("[LA] Returning 메서드 정상 종료 후 실행. 리턴값 = "+ret);
	}
	@AfterThrowing(pointcut=publicMethod, throwing="ex")
	public void afterThrowing(Throwable ex) { //ex : 예외객체
		System.out.println
		("[LA] Throwing 메서드 예외 종료 후 실행. 예외메세지 = "+ ex.getMessage());
	}
	@After(publicMethod)
	public void afterFinally() {
		System.out.println("[LA] After 메서드 종료 후 실행");
	}
}
