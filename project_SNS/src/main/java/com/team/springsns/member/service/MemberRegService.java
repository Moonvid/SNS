package com.team.springsns.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.member.dao.MemberDaoInterface;
import com.team.springsns.model.MemberInfo;

public class MemberRegService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDaoInterface memberDao;		
	

	@Transactional
	public int memberReg(MemberInfo memberInfo, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {

		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		
		// 자동으로 pool 통해서 커넥션 객체 가져옴
		int resultCnt = 0;
		
		// db에는 string 값 저장하는 것임
		// 물리적으로 파일 이름 저장하고 DB에 저장하기위한 작업
		// 물리적 저장 경로(uploadfile - userphoto)
		String uploadUri = "/uploadfile/userphoto";
		
		// uploadUri 경로의 시스템 경로 찾기
		String dir= request.getSession().getServletContext().getRealPath(uploadUri);
		System.out.println(dir);
		// DB 저장용 파일 이름, 물리적 저장할 때의 이름 (DB에 있는 이름 = 실제 파일 이름)
		String imgName = "";
		
		//multipartFile이 있어야 저장 가능함
		if(!memberInfo.getPhotoFile().isEmpty()) {
																		//확장자 포함한 파일 이름
			imgName = (memberInfo.getUserId()) + "_" + memberInfo.getPhotoFile().getOriginalFilename(); 
			
			// 실제로 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
			
			// DB에 저장할 이름 set
			memberInfo.setUserProfilePhoto(imgName);
			
			// 사진이 들어간 디렉토리 출력
			System.out.println(dir);
						
		}
		
			// 질의문 개수
			resultCnt = memberDao.insertMemberInfo(memberInfo);  

		return resultCnt;

	}

}
