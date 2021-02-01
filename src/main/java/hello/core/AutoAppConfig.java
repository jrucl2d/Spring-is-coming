package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component 어노테이션 부튼 컴포넌트를 자동으로 스프링빈으로 등록해줌
//        basePackages = "hello.core.member", // 위치를 지정할 수 있음, 이 이하 하위 패키지 모두 탐색
        // 수동으로 등록한 AppConfig는 제외하기 위해서 -> 예제 코드를 살리기 위해. 실무에서는 안 함
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
