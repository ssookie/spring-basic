package hola.springbasic;

import hola.springbasic.repository.MemberRepository;
import hola.springbasic.repository.MemoryMemberRepository;
import hola.springbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean   // 스프링 빈으로 등록할거야!
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {    // Interface (New 불가)
        return new MemoryMemberRepository();    // 구현체
    }
}
