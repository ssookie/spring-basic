package hola.springbasic;

import hola.springbasic.discount.DiscountPolicy;
import hola.springbasic.discount.FixDiscountPolicy;
import hola.springbasic.discount.RateDiscountPolicy;
import hola.springbasic.member.MemberService;
import hola.springbasic.member.MemberServiceImpl;
import hola.springbasic.member.MemoryMemberRepository;
import hola.springbasic.order.OrderService;
import hola.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션에 대한 환경 설정은 AppConfig 클래스에서 함.
 */
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 필드 주입 예제 테스트를 위한 주석 처리.
        return null;
    }

    @Bean
    // 중복인 함수 -> Extract Method
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
