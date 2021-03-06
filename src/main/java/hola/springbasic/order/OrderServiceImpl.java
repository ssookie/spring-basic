package hola.springbasic.order;

import hola.springbasic.discount.DiscountPolicy;
import hola.springbasic.discount.FixDiscountPolicy;
import hola.springbasic.discount.RateDiscountPolicy;
import hola.springbasic.member.Member;
import hola.springbasic.member.MemberRepository;
import hola.springbasic.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // 구현체 생성 - MemoryMemberRepository 와 FixDiscountPolicy
    // 회원 조회를 위함.
    private final MemberRepository memberRepository; // = new MemoryMemberRepository();
    // 할인 정책 조회를 위함.
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 인터페이스에만 의존하도록 코드 변경
    private final DiscountPolicy discountPolicy;

    // @RequiredArgsConstructor 어노테이션은, 아래 생성자와 동일한 동작 수행함.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 스프링 단일 책임 원칙이 잘 구현됨.
        Member member = memberRepository.findById(memberId).get();
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
