package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

//        @Bean(initMethod = "init", destroyMethod = "close") //destroyMethod는 추론을 사용한다. close, shutdown이라는 메소드가 존재하면 따로 destroyMethod를 선언하지 않아도 추론하여 호출한다. destroyMethod를 사용하고 싶지 않으면 destroyMethod = "" 지정.
        @Bean
        public NetworkClient networdClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}