package com.example.demo.member;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.PrBoard.PrBoardController;

	@Controller
	@RequestMapping("/member/*")
	public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);

		@Autowired
		private MemberLogic memberLogic = null;
		
		@GetMapping("memberList")
		public ModelAndView memberList(@RequestParam Map<String,Object> pMap, Model model) {
			logger.info("MemberList 호출 성공");
			logger.info("사용자가 입력한 정보 ==> "+pMap);
			List<Map<String,Object>> memberList = null;
			memberList = memberLogic.memberList(pMap);
			model.addAttribute("memberList", memberList);
			return new ModelAndView("/member/memberList");
		}
		
		
		
		
		
}
