package hello.core;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    // 필드 주입은 권장되지 않지만 configuration 파일에서는 사용할 수 있다.
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    @MainDiscountPolicy
    DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService(){
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }

//    @Bean // 이렇게도 가능
//    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }
}
