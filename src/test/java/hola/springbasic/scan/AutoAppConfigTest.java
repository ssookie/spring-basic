package hola.springbasic.scan;

import hola.springbasic.AutoAppConfig;
import hola.springbasic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    /**
     * 13:13:32.222 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/aop/TimeTraceAop.class]
     * 13:13:32.229 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/controller/HelloController.class]
     * 13:13:32.230 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/controller/HomeController.class]
     * 13:13:32.231 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/discount/RateDiscountPolicy.class]
     * 13:13:32.234 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/member/MemberServiceImpl.class]
     * 13:13:32.235 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/member/MemoryMemberRepository.class]
     * 13:13:32.236 [Test worker] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/HS/ssookiene/spring-basic/build/classes/java/main/hola/springbasic/order/OrderServiceImpl.class]
     */
}
