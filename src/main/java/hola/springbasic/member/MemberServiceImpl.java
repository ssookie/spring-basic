package hola.springbasic.member;

import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    // 구현 객체 생성해주기
    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        // 다형성에 의해, MemberRepository의 save 메서드가 호출됨.
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
