package hola.springbasic.service;

import hola.springbasic.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() { // 빌드될 때, 테스트 코드는 실제 코드에 포함되지 않음.
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long savedId = memberService.join(member);

        // then
        memberService.findOne(savedId);
        Assertions.assertThat();
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}