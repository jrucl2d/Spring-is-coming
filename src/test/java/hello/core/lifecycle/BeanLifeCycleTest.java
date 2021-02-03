package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        // 외부 라이브러리에 대해서도 초기화, 종료 메서드 설정해줄 수 있는 장점이 있다.
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean // PostConstruct, PreDestroy 어노테이션 사용시
        public NetworkClient networkClient(){
            NetworkClient client = new NetworkClient();
            client.setUrl("http://hello-spring.dev");
            return client;
        }
    }
}
