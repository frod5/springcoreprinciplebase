package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder() {
        //given
        Member member = new Member(1L,"memberB", Grade.VIP);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(),"itemB",10000);
        //then
        Assertions.assertThat(order.getDicountPrice()).isEqualTo(1000);
    }
}
