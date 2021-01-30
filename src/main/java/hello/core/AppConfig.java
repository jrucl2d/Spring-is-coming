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

// 어플리케이션 실제 동작에 필요한 구현 객체를 생성하는 역할
public class AppConfig {
    // 중복이 제거되었고, 역할과 구현 클래스가 한 눈에 들어온다.
    private MemberRepository nemberRepository() {
        return new MemoryMemberRepository();
    }
    // 할인 정책을 변경하기 쉬워졌다. -> AppConfig(구성 영역)만 변경하고 사용 영역은 변경하지 않는다.
    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(nemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(nemberRepository(), discountPolicy());
    }

}
