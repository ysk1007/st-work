package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;
import com.example.mbboard.service.IRootService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired ILoginService loginService;
	@Autowired IRootService rootService;

	@GetMapping("findMemberPw")
	public String findMemberPw() {
		return "findMemberPw";
	}
	
	@PostMapping("findMemberPw")
	public String findMemberPw(Member member) {
		// 비밀번호 변경
		loginService.updateMemberPwByAdmin(member);
		
		// 비밀번호 변경 페이지로 
		return "redirect:/rechangeMemberPw";
	}
	
	@GetMapping("rechangeMemberPw")
	public String rechangeMemberPw() {
		return "rechangeMemberPw";
	}
	
	// 비밀번호 수정 기능
	@PostMapping("/rechangeMemberPw")
	public String rechangeMemberPw(RedirectAttributes redirectAttributes, Member member, @RequestParam("reMemberPw") String reMemberPw) {
	    Member target = loginService.selectMember(member);
	    if (target == null) {
	        redirectAttributes.addFlashAttribute("message", "잘못된 아이디/비밀번호 입니다.");
	        return "redirect:/rechangeMemberPw";
	    }

	    member.setMemberPw(reMemberPw);
	    int row = loginService.rechangeMemberPw(member);
	    
	    if (row != 1) {
	        redirectAttributes.addFlashAttribute("message", "10분이 지났습니다. 다시 비밀번호를 찾아주세요.");
	    } else {
	        redirectAttributes.addFlashAttribute("message", "성공적으로 비밀번호를 수정 했습니다.");
	    }

	    return "redirect:/logout";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes, @ModelAttribute("message") String message) {
	    session.invalidate(); // 세션 초기화

	    // 메시지를 다시 flash로 넘겨줌 (두 번째 redirect를 위한 중계)
	    redirectAttributes.addFlashAttribute("message", message);

	    return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			return "/member/memberHome";
		}
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Model model,Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		
		if(loginMember != null) {
			
			// 클라이언트 쿠키에도 로그인에 성공한 ID만 저장
			if(paramMember.getSaveIdCk() != null) {
				Cookie cookie = new Cookie("saveId",paramMember.getMemberId());
				response.addCookie(cookie);
			}
			else {
				Cookie cookie = new Cookie("saveId","");
				response.addCookie(cookie);
			}
			
			session.setAttribute("loginMember", loginMember);
			ConnectCount cc = new ConnectCount();
			cc.setMemberRole(loginMember.getMemberRole());
			if(rootService.getConnectDateByKey(cc) != null) {
				rootService.modifyConnectCount(cc);		// 오늘 날짜 count = count + 1
			}
			else {
				rootService.addConnectCount(cc);		// 오늘 날짜 count = 1 추가
			}
			return "/member/memberHome";
		}
		
		// 로그인 실패
		model.addAttribute("message","로그인 실패!");
		return "/login";
	}

	@GetMapping("/member/info")	// 세션안에 상세정보를 보여주는 요청 -> 로그인 된 상태에서 요청 가능 -> 필터1
	public String info() {		
		return "/member/info";
	}
	
	@GetMapping("/admin/adminHome")	// 관리자 페이지 요청 -> 로그인 된 상태이고 role이 'ADMIN' 요청 가능 -> 필터2
	public String adminHome(Model model) {
		List<Member> memberList = loginService.selectMemberList();
		model.addAttribute("memberList", memberList);
		return "/admin/adminHome";
	}
	
	// 회원 가입 페이지
	@GetMapping("/joinMember")
	public String joinMember() {
		return "joinMember";
	}
	
	// 회원 가입 기능
	@PostMapping("/joinMember")
	public String joinMember(Member member) {
		member.setMemberRole("MEMBER");
		int row = loginService.joinMember(member);
		if(row != 1) {
			throw new RuntimeException();
		}
		return "redirect:/login";
	}
	
	// 비밀번호 수정 페이지
	@GetMapping("/member/updatePw")
	public String updatePw() {
		return "/member/updatePw";
	}
	
	// 비밀번호 수정 기능
	@PostMapping("/member/updatePw")
	public String updatePw(Member member, @RequestParam (value="newPw") String newPw) {
		member.setMemberPw(newPw);
		log.info("LoginController : " + newPw);
		int row = loginService.updateMember(member);
		if(row != 1) {
			throw new RuntimeException();
		}
		
		return "redirect:/logout";
	}
	
	@GetMapping("/member/memberHome")
	public String memberHome() {
		return "/member/memberHome";
	}
}
