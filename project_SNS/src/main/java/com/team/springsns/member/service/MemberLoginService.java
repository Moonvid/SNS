package com.team.springsns.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.team.springsns.member.dao.MemberDaoInterface;
import com.team.springsns.model.MemberInfo;

public class MemberLoginService {

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private MemberDaoInterface memberDao;
	
	public boolean login(String id, String pw, HttpSession session) throws SQLException {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		
		boolean result = false;
		
		MemberInfo memberInfo = memberDao.getMemberInfo(id); // id로 셀렉트하고 값을 가져옴
		
		// 사용자가 입력한  id의 데이터 존재 유무 확인           비밀번호 비교 - null이면 그냥  null 들어온거임
		if(memberInfo != null && memberInfo.getUserPassword().equals(pw)) {
						
			// 같으면 로그인 처리 
			memberInfo.setUserPassword("");// 회원 리스트 불러올때라던가 비밀번호 안보이게 하려고
			//세션에 사용자 데이터 저장
			session.setAttribute("loginInfo", memberInfo);
				
			result = true;
		}
		return result;
	}
}
