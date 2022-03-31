package com.example.demo.member;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLogic {
	Logger logger = LogManager.getLogger(MemberLogic.class);
	
	@Autowired
	private MemberDao memberdao = null;
	
	
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		List<Map<String, Object>> memberList = null;
		memberList=memberdao.memberList(pMap);
		
		return memberList;
	}

	public Map<String, Object> loginAction(Map<String, Object> pMap) {
		Map<String,Object> rmap=memberdao.loginAction(pMap);
		
		return rmap;
	}


	public Map<String, Object> proc_login(Map<String, Object> pMap) {
		Map<String,Object> rmap= null;
		rmap = memberdao.proc_login(pMap);
		return rmap;
	}


	public int memberInsert(Map<String, Object> pMap) {
		int result = 0;
		result = memberdao.memberInsert(pMap);
			return result;
	}



}
