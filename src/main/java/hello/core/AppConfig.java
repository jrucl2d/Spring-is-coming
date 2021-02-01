package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 어플리케이션 실제 동작에 필요한 구현 객체를 생성하는 역할
//@Configuration // 바이트 코드 조작으로 완벽한 싱글톤 패턴을 보장하지만 configuration을 지우면 바이트 코드 조작이 이루어지지 않음 -> 싱글톤 X
public class AppConfig {
    // 중복이 제거되었고, 역할과 구현 클래스가 한 눈에 들어온다.
    @Bean
    public MemberRepository nemberRepository() {
        return new MemoryMemberRepository();
    }

    // 할인 정책을 변경하기 쉬워졌다. -> AppConfig(구성 영역)만 변경하고 사용 영역은 변경하지 않는다.
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(nemberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(nemberRepository(), discountPolicy());
    }

}
