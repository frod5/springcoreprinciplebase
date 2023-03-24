package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //@Bean으로 선언된 것들을 Spring container로 사용할 수 있도록 해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);

        memberService.join(member);

        Member fimdMember = memberService.findMember(1L);

        System.out.println("new Member >>>>> "+member.getName());
        System.out.println("find Member >>>>> "+fimdMember.getName());
    }
}
