package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {

//	DAO
	@Autowired
	private MemberDAO memberDAO;
//	검증메서드
	public boolean getMemberError(MemberVO memberVO,BindingResult bindingResult) throws Exception{
		boolean check = false; //false 면 error가 발생하지 않는다 true일떄 검증 실패 라고 가정
		
//		password 일치 검증
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			check = true; // or !check;
			
			bindingResult.rejectValue("passwordCheck", "memberVO.password.equalCheck");
		}
		//ID 중복 검사
		 MemberVO checkVO = memberDAO.getMember(memberVO);
		 if(checkVO != null) {
			 check = true;
			 bindingResult.rejectValue("username", "memberVO.username.equalCheck");
		 }
		
		return check;
	}
//	 login
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		 MemberVO loginVO = memberDAO.getMember(memberVO);
		 
		 if(loginVO == null) {
			 return loginVO;
		 }
		 
		 if(loginVO.getPassword().equals(memberVO.getPassword())) {
			 
			 return loginVO;
		 }
		 return null;
	}
	

	
	
	
	
}
