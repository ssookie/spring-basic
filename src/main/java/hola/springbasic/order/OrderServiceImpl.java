package hola.springbasic.order;

import hola.springbasic.discount.DiscountPolicy;
import hola.springbasic.discount.FixDiscountPolicy;
import hola.springbasic.member.Member;
import hola.springbasic.member.MemberRepository;
import hola.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 구현체 생성 - MemoryMemberRepository 와 FixDiscountPolicy
    // 회원 조회를 위함.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정책 조회를 위함.
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 스프링 단일 책임 원칙이 잘 구현됨.
        Member member = memberRepository.findById(memberId).get();
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
