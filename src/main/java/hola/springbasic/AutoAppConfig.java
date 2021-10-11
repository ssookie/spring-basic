package hola.springbasic;

import hola.springbasic.discount.DiscountPolicy;
import hola.springbasic.member.MemberRepository;
import hola.springbasic.member.MemoryMemberRepository;
import hola.springbasic.order.OrderService;
import hola.springbasic.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        // 탐색할 패키지의 시작 위치 지정, 하위 패키지 모두 탐색
        basePackages = "hola.springbasic",
        // 기존 AppConfig.java 의 bean 과 충돌하지 않도록 (기존 예제 코드를 최대한 남기고 유지하기 위해서)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다!

    // [TEST] 수동 빈 등록 vs 자동 빈 등록에서 빈 이름이 충돌되면?
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
