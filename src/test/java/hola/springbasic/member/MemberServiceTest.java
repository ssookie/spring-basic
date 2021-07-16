package hola.springbasic.member;

import hola.springbasic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemberServiceTest {

    /**
     * AppConfig 를 사용하도록 변경.
     */
    MemberService memberService; // = new MemberServiceImpl();

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        memberService.join(member);
        Optional<Member> findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember.get());  // optional class에서 내부적으로 갖고있는 값 꺼내기
    }
}
