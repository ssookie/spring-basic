package hola.springbasic.Controller;

import hola.springbasic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

/*    // private final MemberService memberSerivce = new MemberService();
    private final MemberService memberService;

    @Autowired // 생성자 호출시 Autowired → 스프링이 스프링 컨테이너에 있는 memberService를 가져와서 연결시켜줌.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }*/

    // setter 주입
    private MemberService memberService;

    @Autowired
    public void MemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}
