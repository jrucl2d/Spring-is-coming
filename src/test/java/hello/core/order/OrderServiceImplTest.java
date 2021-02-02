package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        // setter DI를 사용하면 orderServiceImpl에서 사용하는 것들을 미리 알 수 없어 파일을 까봐야 한다.
        // 생성자 주입을 사용하면 new 할시 빨간 줄이 생기기 때문에 바로 알 수 있다.
        // mock을 사용하거나 임의의 객체를 new 해서 넣어줄 수 있다.
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "MemberA" , Grade.VIP));

        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}