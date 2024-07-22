package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JDBCTemplate;
import member.model.vo.Member;

// static import -> 임포트된 클래스를 마치 자신의 메소드처럼 활용할수 있다.
import static common.JDBCTemplate.*;

public class MemberDao {
	/**
	 ■ DAO 설계 지침
	 1. 기본적으로 관련 Table과 1:1 매핑하는게 일반적 설계
	    단, 기능에 따라 다중 Table을 다루기도 함 ex) BoardDao = board + reply + favorites
		       
	 2. 쿼리 외의 부가기능은 서비스나 JDBC Template로 이관 
	 */
	
	public List<Member> selectAll(Connection conn){
		List<Member> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM MEMBER ORDER BY MNO";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int mno             = rs.getInt("mno");       
				String id           = rs.getString("id");        
				String password     = rs.getString("password");  
				String name         = rs.getString("name");      
				String gender       = rs.getString("gender");    
				int age             = rs.getInt("age");       
				String email        = rs.getString("email");     
				String phone        = rs.getString("phone");     
				String address      = rs.getString("address");   
				String hobby        = rs.getString("hobby");     
				Date birthday       = rs.getDate("birthday");  
				Date enrolldate     = rs.getTimestamp("enrolldate");
				Member m = new Member(mno, id, password, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
				list.add(m);
			}
			close(pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 만일 실패해도 빈리스트가 나가는게 유리하다.
	}
	
	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		try {
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int mno             = rs.getInt("mno");       
				String id           = rs.getString("id");        
				String password     = rs.getString("password");  
				String name         = rs.getString("name");      
				String gender       = rs.getString("gender");    
				int age             = rs.getInt("age");       
				String email        = rs.getString("email");     
				String phone        = rs.getString("phone");     
				String address      = rs.getString("address");   
				String hobby        = rs.getString("hobby");     
				Date birthday       = rs.getDate("birthday");  
				Date enrolldate     = rs.getTimestamp("enrolldate");
				m = new Member(mno, id, password, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
			}
			close(pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m; 
	}
	
	// like절로 
	public List<Member> selectByName(Connection conn, String memberName) {
		List<Member> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM MEMBER WHERE NAME LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			// like절 % 붙이는 방법 : setString 메소드 인자 안에서 '%' 붙여서 '%길동%'를 만든다. 
			pstmt.setString(1, "%" + memberName + "%"); // 홍길동
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int mno             = rs.getInt("mno");       
				String id           = rs.getString("id");        
				String password     = rs.getString("password");  
				String name         = rs.getString("name");      
				String gender       = rs.getString("gender");    
				int age             = rs.getInt("age");       
				String email        = rs.getString("email");     
				String phone        = rs.getString("phone");     
				String address      = rs.getString("address");   
				String hobby        = rs.getString("hobby");     
				Date birthday       = rs.getDate("birthday");  
				Date enrolldate     = rs.getTimestamp("enrolldate");
				Member m = new Member(mno, id, password, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
				list.add(m);
			}
			close(pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 만일 실패해도 빈리스트가 나가는게 유리하다.
		
	}
	
	public int insertMember(Connection conn, Member member) {
		try {
			String sql = "INSERT INTO MEMBER VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int count = 1;
			pstmt.setString(count++, member.getId());
			pstmt.setString(count++, member.getPassword());
			pstmt.setString(count++, member.getName());
			pstmt.setString(count++, member.getGender());
			pstmt.setInt(count++, member.getAge());
			pstmt.setString(count++, member.getEmail());
			pstmt.setString(count++, member.getPhone());
			pstmt.setString(count++, member.getAddress());
			pstmt.setString(count++, member.getHobby());
			pstmt.setDate(count++, new java.sql.Date(member.getBirthday().getTime()));
			
			int result = pstmt.executeUpdate();
			close(pstmt);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public int updateMember(Connection conn, Member member) {
		try {
			String sql = "UPDATE MEMBER SET PASSWORD = ?, EMAIL = ?, PHONE = ?, "
											+ "ADDRESS = ?, HOBBY = ? WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getHobby());
			pstmt.setString(6, member.getId());
			int result = pstmt.executeUpdate();
			close(pstmt);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public int deleteMember(Connection conn, String memberId) {
		try {
			String sql = "DELETE FROM MEMBER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, memberId);
			int result = pstmt.executeUpdate();
			close(pstmt);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Connection conn = JDBCTemplate.openConnection();
		MemberDao dao = new MemberDao();
		List<Member> list = dao.selectAll(conn);
		list.forEach((v)->System.out.println(v));
		System.out.println("---------------------------------------------------");
		Member m = dao.selectOne(conn, "user1");
		System.out.println(m);
		System.out.println("---------------------------------------------------");
		m.setId("test12122");
		int result = dao.insertMember(conn, m);
		System.out.println("insert result : "+ result);
		System.out.println("---------------------------------------------------");
		list = dao.selectAll(conn);
		list.forEach((v)->System.out.println(v));
		System.out.println("---------------------------------------------------");
	}
}
