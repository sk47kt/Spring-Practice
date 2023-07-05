package stu.sk47kt.sk47kt_spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import stu.sk47kt.sk47kt_spring.domain.Member;
import stu.sk47kt.sk47kt_spring.service.MemberService;

import java.util.List;

@Controller
public class MemberController{

    // 생성자 주입
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
        public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/membersList";
    }


    //setter 주입
    /*private MemberService memberService;

    @AutoWired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/


    
}
