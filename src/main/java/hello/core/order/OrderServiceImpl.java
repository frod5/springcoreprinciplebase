package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    RateDiscountPolicy에 @Primary를 선언하면 중복되는 빈이 있는경우 우선순위로 가져간다.
//    @Primary와 @Qualifier가 있는 경우 에는 Qualifier가 우선순위가 높다.
//    @Autowired 같은 타입의 빈이 있는 경우 ex) DiscountPolicy가 rateDiscountPolicy, fixDiscountPolicy 있는 경우 오류가 나는데, DiscountPolicy rateDiscountPolicy로 선언하면 필드 이름을 보고 주입하여 준다
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("fixDiscountPolicy") DiscountPolicy discountPolicy) { // @Qualifier("fixDiscountPolicy")로 선언 되어 있는 빈을 찾아 주입하여 준다.
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
