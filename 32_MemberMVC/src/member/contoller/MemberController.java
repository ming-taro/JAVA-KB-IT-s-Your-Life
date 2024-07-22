package member.contoller;

import java.util.List;

import member.model.service.MemberService;
import member.model.vo.Member;

// Controller : Spring에서는 url을 통해 요청을 받고 서비스를 다중으로 보유할수 있는 객체
public class MemberController {
	MemberService service = new MemberService();
//	BoardService boardService = new BoardService();
//	ShopService shopService = new ShopService();

	public List<Member> getAllMemberList() {
		return service.getAllMemberList();
	}

	public Member searchById(String memberId) {
		return service.searchById(memberId);
	}

	public List<Member> searchByName(String memberName) {
		return service.searchByName(memberName);
	}

	public int insertMember(Member member) {
		return service.insertMember(member);
	}

	public int updateMember(Member member) {
		return service.updateMember(member);
	}

	public int deleteMember(String memberId) {
		return service.deleteMember(memberId);
	}
}
