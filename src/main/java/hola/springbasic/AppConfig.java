package hola.springbasic;

import hola.springbasic.discount.FixDiscountPolicy;
import hola.springbasic.member.MemberService;
import hola.springbasic.member.MemberServiceImpl;
import hola.springbasic.member.MemoryMemberRepository;
import hola.springbasic.order.OrderService;
import hola.springbasic.order.OrderServiceImpl;

/**
 * 애플리케이션에 대한 환경 설정은 AppConfig 클래스에서 함.
 */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
