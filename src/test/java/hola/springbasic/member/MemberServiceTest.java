package hola.springbasic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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
