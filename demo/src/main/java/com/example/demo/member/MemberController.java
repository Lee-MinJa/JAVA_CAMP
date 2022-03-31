package com.example.demo.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


	@Controller
	@RequestMapping("/member/*")
	public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);

		@Autowired
		private MemberLogic memberLogic = null;
		
		@GetMapping("memberList")
		public ModelAndView memberList(@RequestParam Map<String,Object> pMap, Model model ) {
			logger.info("MemberList 호출 성공");
			logger.info("사용자가 입력한 정보 ==> "+pMap);
			List<Map<String,Object>> memberList = null;
			memberList = memberLogic.memberList(pMap);
			model.addAttribute("memberList", memberList);
			return new ModelAndView("/member/memberList");
		}
		
		@GetMapping("memberLogin")
		public ModelAndView memberLogin(@RequestParam Map<String,Object> pMap, Model model, HttpSession session ) {
			logger.info("MemberLogin 호출 성공");
			logger.info("사용자가 입력한 정보 ==> "+pMap);
			List<Map<String,Object>> memberList = null;
			memberList = memberLogic.memberList(pMap);
			
			model.addAttribute("mem_id", memberList.get(0).get("MEM_ID").toString());
			model.addAttribute("mem_nick", memberList.get(0).get("MEM_NICK").toString());
			
			session.setAttribute("mem_id",memberList.get(0).get("MEM_ID").toString());
			session.setAttribute("mem_nick",memberList.get(0).get("MEM_NICK").toString());
			
			return new ModelAndView("/member/memberList");
		}
		
		@GetMapping("memberLogOut")
		public  @ResponseBody String memberLogout(HttpServletRequest request, Model model, HttpSession session) {
				//setComplete 메소드 호출로 해당세션 폐기
			String mem_id = (String)session.getAttribute("mem_id");
			String mem_nick = (String)session.getAttribute("mem_nick");
			String msg=null;
			session.invalidate();
				if(request.isRequestedSessionIdValid() == true) {
					logger.info("sessionStatus 호출성공");
					msg="세션이름: "+ mem_id + ", 세션 아이디: "+mem_nick;
					return msg;//  /spring 으로 리다이렉트
				}
				else {
					msg="로그아웃되었습니다!";
					String loc="/";
					return msg;//  /spring 으로 리다이렉트
				}
		}
		
		@GetMapping("/userInfo")
		public @ResponseBody String userInfo(@RequestParam Map<String,Object>pMap, HttpSession session) {
			String mem_id = (String)session.getAttribute("mem_id");
			String mem_nick = (String)session.getAttribute("mem_nick");
			return "세션이름: "+ mem_id + ", 세션 아이디: "+mem_nick;
		}
	
		
		@GetMapping("memberInsert")
		public ModelAndView memberInsert(@RequestParam Map<String,Object> pMap, Model model ) {
			logger.info("MemberInsert 호출 성공");
			logger.info("사용자가 입력한 정보 ==> "+pMap);
			int result = 0;
			result = memberLogic.memberInsert(pMap);
			
			return new ModelAndView("/member/memberList");
		}
		
		
		
		
		
}