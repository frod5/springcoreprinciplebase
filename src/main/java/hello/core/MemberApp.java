package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L,"memberA", Grade.VIP);

        memberService.join(member);

        Member fimdMember = memberService.findMember(1L);

        System.out.println("new Member >>>>> "+member.getName());
        System.out.println("find Member >>>>> "+fimdMember.getName());
    }
}
