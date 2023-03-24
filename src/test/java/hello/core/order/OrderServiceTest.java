package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void init() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
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
