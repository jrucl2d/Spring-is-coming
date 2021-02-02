package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        

    }

    static class TestBean{
        // required가 true(기본값)면 오류 터짐. false면 의존관계가 아예 없을 시 호출 자체가 안 됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){ // 스프링이 관리하는 Bean이 아닌 Memeber
            System.out.println("noBean1 = " + noBean1);
        }
        
        @Autowired // null이 출력됨
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        
        @Autowired // Optional.empy가 출력됨
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
