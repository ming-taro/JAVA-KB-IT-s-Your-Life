package com.boxoffice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.boxoffice.common.JDBCTemplate;
import com.boxoffice.model.vo.Member;

public class MemberDao {
	
	public Member selectOne(Connection conn, int mNo) {
		try {
			String sql = "SELECT * FROM MEMBER WHERE MNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, mNo);

			ResultSet rs = pstmt.executeQuery(); 
			rs.next(); 
			mNo 	= 		rs.getInt(1);
			String id = 	rs.getString(2);
			String password = rs.getString(3);
			String name 	= rs.getString(4);

			Member member = new Member(mNo, id, password, name);
			
			pstmt.close();
			rs.close();
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Member selectByID(Connection conn, String id) {
		try {
			String sql = "SELECT * FROM MEMBER WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery(); 
			rs.next(); 
			int mno 	= 		rs.getInt(1);
			id 			 = 	rs.getString(2);
			String password = rs.getString(3);
			String name 	= rs.getString(4);
			
			Member member = new Member(mno, id, password, name);
			
			pstmt.close();
			rs.close();
			return member;
		} catch (Exception e) {
		}
		return null;
	}
	

	public int insert(Connection conn, Member member) {
		try {
			String sql = "INSERT INTO MEMBER VALUES(0, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql); 

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}

	
	public static void main(String[] args) {
		Connection conn = JDBCTemplate.openConnection();
		Member member = new MemberDao().selectOne(conn, 2);
		System.out.println(member);
		member = new MemberDao().selectByID(conn, "test1");
		System.out.println(member);
	}
}
