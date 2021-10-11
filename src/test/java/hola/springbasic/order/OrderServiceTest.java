package hola.springbasic.order;

import hola.springbasic.AppConfig;
import hola.springbasic.discount.DiscountPolicy;
import hola.springbasic.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    @Test
    void createOrder(){
        Long memberId = 1L; // primitive type "long"을 쓸 수도 있지만, 해당 변수에는 null이 안들어가므로 Long 사용.
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

//    @Test
//    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L, "itemA", 10000);
//        // Bean named 'orderService' is expected to be of type 'hola.springbasic.order.OrderService' but was actually of type 'org.springframework.beans.factory.support.NullBean' 오류 발생
//    }
}
