package com.example.demo.member;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberDao {
	Logger logger = LogManager.getLogger(MemberDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList DAO 호출 성공");
		List<Map<String, Object>> memberList = null;
		memberList = sqlSessionTemplate.selectList("memberList", pMap);
		logger.info("boardList : "+memberList);
		return memberList;
	}


	public Map<String, Object> loginAction(Map<String, Object> pMap) {
		Map<String, Object> rmap = null;
		rmap = sqlSessionTemplate.selectOne("loginAction",pMap);
		logger.info("rmap : " +rmap);
		return rmap;
	}

	public Map<String, Object> proc_login(Map<String, Object> pMap) {
		sqlSessionTemplate.selectOne("proc_login2022",pMap);
		logger.info("pMap : "+pMap);
		return pMap;
	}

	public int memberInsert(Map<String, Object> pMap) {
		int result = 0;
		result = sqlSessionTemplate.insert("memberInsert",pMap);
		logger.info("result ====>" +result);
		return result;
	}

}
