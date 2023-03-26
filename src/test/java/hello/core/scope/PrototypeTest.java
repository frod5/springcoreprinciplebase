package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class); //scope: prototype은 빈이 조회 될떄 생 및 초기화 메소드 생성
        System.out.println("find PrototypeBean1");

        PrototypeBean bean2 = ac.getBean(PrototypeBean.class); //scope: prototype은 빈이 조회 될떄 생 및 초기화 메소드 생성
        System.out.println("find PrototypeBean1");

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);  // 서로 다름.
        ac.close();  ////scope: prototype은 @PreDestroy가 선언된 메소드 실행 x

        //destroy하고 싶으면 클라이언트가 직접 호출해야한다.
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
