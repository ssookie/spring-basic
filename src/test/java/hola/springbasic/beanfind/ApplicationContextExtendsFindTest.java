package hola.springbasic.beanfind;

import hola.springbasic.discount.DiscountPolicy;
import hola.springbasic.discount.FixDiscountPolicy;
import hola.springbasic.discount.RateDiscountPolicy;
import hola.springbasic.member.MemberRepository;
import hola.springbasic.member.MemoryMemberRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextExtendsFindTest {
    /**
     * Test 를 위한 Config Class
     */
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
