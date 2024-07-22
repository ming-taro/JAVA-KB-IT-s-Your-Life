package member.model.service;

//import static : static 메소드를 자기 메소드처럼 활용할수 있는 기법
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

// model단 코드로 Member에 관련된 서비스를 담당하는 코드 (DAO를 소유하고 있는 객체)
// Service는 DAO를 여러개를 보유 할수도 있다.
public class MemberService {
	/**
	 * Service의 역할
	 * 1. 특정 기능에 대한 모든 서비스를 담당하는 구조로 Table(DAO)가 다중일지라도 컨트롤러에서는 하나의 구조로 보이게끔 하는 역할
	 *    ex) 다중 DAO 관리, Join문 or 다중쿼리 관리, 다중 트랜잭션 관리
	 * 
	 * 2. DB 상태, 접속 관리
	 *   - 생성, Connection 관리, 종료
	 *   
	 *   예시1)
	 *   3개의 DAO에서 정보를 조회해 올 때 -> Service에서는 3개의 DAO로 부터 데이터를 받아와 하나의 객체로 반환함
	 *   Member       / Job    / Hobby
	 *   ID/이름/J1     J1/주임    ID/취미1, ID/취미2
	 *   --> 컨트롤러로 전달 할 때는 MemberDTO에 Member, Job, Hobby에 대한 정보를 묶어서 전달함
	 *   
	 *   예시2)
	 *   DELETE 할때 총 2개의 Member, Hobby 테이블이 존재할때 두개의 DELETE문을 트랜잭션으로 묶어서 관리
	 *   모두 성공하면 commit, 만일 하나만 삭제되고 후단에서 error가 발생하는 경우 rollback 시킬수 있음
	 */
	
	private MemberDao memberDao = new MemberDao();
//	private JobDao jobDao = new MemberDao(); // 예시
//	private HobbyDao hobbyDao = new MemberDao();

	
	private Connection conn;
	
	public MemberService() {
		conn = openConnection();
	}
	
	// 서비스 메소드를 정의
	//	selectAll(Connection)
	//	selectOne(Connection, String)
	//	selectByName(Connection, String)
	//	insertMember(Connection, Member)
	//	updateMember(Connection, Member)
	//	deleteMember(Connection, String)
	
	public List<Member> getAllMemberList(){
		return memberDao.selectAll(conn);
	}
	
	public Member searchById(String memberId) {
		return memberDao.selectOne(conn, memberId);
	}
	
	public List<Member> searchByName(String name) {
		return memberDao.selectByName(conn, name);
	}
	
	public int insertMember(Member member) {
		int result = memberDao.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public int updateMember(Member member) {
		int result = memberDao.updateMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public int deleteMember(String memberId) {
		int result = memberDao.deleteMember(conn, memberId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	
	
}















