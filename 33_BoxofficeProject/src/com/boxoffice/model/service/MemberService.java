package com.boxoffice.model.service;


import static com.boxoffice.common.JDBCTemplate.commit;
import static com.boxoffice.common.JDBCTemplate.openConnection;
import static com.boxoffice.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.boxoffice.model.dao.MemberDao;
import com.boxoffice.model.vo.Member;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
	private Connection conn = null;
	
	public MemberService() {
		conn = openConnection();
	}

	public Member selectOne(int mno) {
		return memberDao.selectOne(conn, mno);
	}
	
	public Member selectByID(String id) {
		return memberDao.selectByID(conn, id);
	}
	
	public int insert(Member member) {
		int result = memberDao.insert(conn, member);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}


}
