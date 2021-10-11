package hola.springbasic.autowired;

import hola.springbasic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // 임의의 스프링 빈 생성
    static class TestBean {
        /**
         * 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
         */
        @Autowired(required=false)
        public void setNoBean1(Member noBean1) {  // Member은 스프링으로 관리되는 빈이 아님.
            System.out.println("noBean1 = " + noBean1);
        }

        /**
         * null 호출
         */
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2); // noBean2 = null
        }

        /**
         * Optional.empty 호출
         */
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3); // noBean3 = Optional.empty
        }
    }
}
