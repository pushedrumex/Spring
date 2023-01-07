package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// AOP(Aspect Oriented Programming) : 공통 관심 사항과 핵심 관심 사항 분리

@Component
@Aspect
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // hello.hellospring 패키지 하위의 것들 다 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed(); // 다음 메서드 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
