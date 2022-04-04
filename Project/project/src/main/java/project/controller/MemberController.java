package project.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.config.auth.PrincipalDetails;
import project.model.Member;
import project.repository.MemberRepository;

@Controller
public class MemberController {

	Logger logger = LogManager.getLogger(MemberController.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//홈
	@GetMapping({"","/"})
	public @ResponseBody String home() {
		return "HOME";
	}
	
	//회원
	@GetMapping("/member")
	public @ResponseBody String member() {
		return "MEMBER";
	}
	
	//사업자
	@GetMapping("/biz")
	public @ResponseBody String biz() {
		return "BIZ";
	}
	
	//관리자
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "ADMIN";
	}
	
	//회원가입폼
	@GetMapping("/joinForm")
	public String joinForm() {
		return "/joinForm";
	}
	
	//사업자회원가입폼
	@GetMapping("/bizJoinForm") 
	public String bizJoinForm() {
		return "/bizJoinForm";
	}
		
	//회원가입
	@PostMapping("/join")
	public String join(Member member) {
		logger.info("MemberController join member : "+member);
		member.setMemCode(1);
		member.setMemRole("ROLE_MEMBER");
		String rawPassword = member.getMemPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setMemPw(encPassword);
		memberRepository.save(member);
		return "redirect:/login";
	}
	
	//사업자회원가입
	@PostMapping("/bizJoin")
	public String bizJoin(Member member) {
		logger.info("MemberController bizJoin member : "+member);
		member.setMemCode(2);
		member.setMemRole("ROLE_BIZ");
		String rawPassword = member.getMemPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setMemPw(encPassword);
		memberRepository.save(member);
		return "redirect:/login";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/info")
	public @ResponseBody String info() {
		return "INFO";
	}
	
	@PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_BIZ')")
	@GetMapping("/data")
	public @ResponseBody String data() {
		return "DATA";
	}
	
	@GetMapping("/oauth")
	public String oauth() {
		return "/oauth";
	}
	
	@GetMapping("/test/login")
	public @ResponseBody String testLogin(
			Authentication authentication,
			@AuthenticationPrincipal PrincipalDetails userDatails) {
		logger.info("authentication.getPrincipal() : "+authentication.getPrincipal());
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		logger.info("principalDetails.getMember() : "+principalDetails.getMember());
		
		logger.info("userDetails.getUsername() : "+userDatails.getUsername());
		logger.info("userDetails.getMember() : "+userDatails.getMember());
		return "세션정보";
	}
	
	@GetMapping("/test/oauth/login")
	public @ResponseBody String testOauthLogin(
			Authentication authentication,
			@AuthenticationPrincipal OAuth2User oauth) {
		logger.info("authentication.getPrincipal() : "+authentication.getPrincipal());
		OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
		logger.info("oAuth2User.getAttributes() : "+oAuth2User.getAttributes());
		logger.info("oauth.getAttributes() : "+oauth.getAttributes());

		return "OAuth 세션정보";
	}
	
}