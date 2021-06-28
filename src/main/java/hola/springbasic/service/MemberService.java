package hola.springbasic.service;

import hola.springbasic.domain.Member;
import hola.springbasic.repository.MemberRepository;
import hola.springbasic.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    /**
     * 회원 서비스가 메모리 회원 리포지토리를 직접 생성하게 함.
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public long join(Member member) {
        //중복 회원 검증, Optional 이기에 가능함.
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });*/

        /*memberRepository.findByName(member.getName())   // 위에 코드 정리
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });*/

        validateDuplicateMember(member);    // 위에 코드 → option + command + T → extract Methods
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
