package com.boxoffice.controller;


import com.boxoffice.model.service.MemberService;
import com.boxoffice.model.vo.Member;


public class MemberController {
	private MemberService memberService = new MemberService();
	private static Member loginMember = null;
	
	public boolean login(String id, String pw) {
		Member member = memberService.selectByID(id);
		if(member == null) {
			return false;
		}
		
		if(member.getPassword().equals(pw) == true) {
			loginMember = member;
			return true;
		}else {
			return false;
		}
	}

	public static void logout() {
		loginMember = null;
	}
	
	public static Member getLoginMember() {
		return loginMember;
	}
	
}
