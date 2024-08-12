package com.boxoffice.view;

import java.util.List;

import com.boxoffice.common.Util;
import com.boxoffice.controller.BoxofficeController;
import com.boxoffice.controller.CommunityController;
import com.boxoffice.controller.MemberController;
import com.boxoffice.model.vo.Boxoffice;
import com.boxoffice.model.vo.Favorite;
import com.boxoffice.model.vo.Review;
import com.boxoffice.model.vo.Member;

public class BoxofficeMenu {
	private CommunityController communityController = new CommunityController();
	private BoxofficeController boxofficeController = new BoxofficeController();
	private MemberController memberController = new MemberController();
	
	public void mainMenu() {
		boolean isLogin = false;
		String menu = "========== Boxoffice Project Main ===========\n"
					+ "1.DB 초기화\n"
					+ "2.BoxOffice 메뉴\n" 
					+ "3.커뮤니티 메뉴\n" 
					+ "4.로그 아웃\n"
					+ "0.프로그램 끝내기\n"
					+ "---------------------------------------------\n"
					+ "선택 : "; 

		while(true) {
			if(isLogin == false) {
				loginMenu();
				isLogin = true;
			}
			System.out.print(menu);
			int choice = Util.readIntForConsol();
			switch(choice) {
				case 1: 
					boxofficeController.initBoxOffice();
					break;
				case 2: 
					boxofficeMenu();
					break;
				case 3: 
					commnunityMenu();
					break;
				case 4: 
					isLogin = false;
					MemberController.logout();
					System.out.println("로그아웃 되었습니다.\n");
					break;
				case 0: 
					System.out.print("정말로 끝내시겠습니까?(y/n) : ");
					if(Util.readStrForConsol().charAt(0) == 'y')
						return;
					break;
				default: 
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void loginMenu() {
		while(true) {
			System.out.println("================== 로그인 =====================");
			// test2 / 1234 
			System.out.print("아이디 : ");
			String id = Util.readStrForConsol();
			System.out.print("비밀번호 : ");
			String pw = Util.readStrForConsol();
			boolean result = memberController.login(id, pw);
			if(result) {
				System.out.println("로그인에 성공하였습니다!");
				break;
			}else {
				System.out.println("로그인에 실패하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	private void boxofficeMenu() {
		String menu = "========== Boxoffice Menu ==========\n"
				+ "1.전체목록 조회\n"
				+ "2.영화 이름으로 찾기\n" 
				+ "3.주별로 찾기\n" 
				+ "0.이전 메뉴로 돌아가기\n"
				+ "----------------------------------\n"
				+ "선택 : "; 
		while(true) {
			List<Boxoffice> list = null;
			System.out.print(menu);
			int choice = Util.readIntForConsol();
			switch(choice) {
				case 1: 
					list = boxofficeController.getAllMvList();
					printBoxOffice(list);
					break;
				case 2: 
					System.out.print("찾을 영화 제목 : ");
					String name = Util.readStrForConsol();
					list = boxofficeController.searchMovieName(name);
					printBoxOffice(list);
					break;
				case 3: 
					System.out.print("찾을 주간(ex :202301 ) : ");
					String yearweekTime = Util.readStrForConsol();
					list = boxofficeController.getMvListByYearweekTime(yearweekTime);
					printBoxOffice(list);
					break;
				case 0: 
					return;
				default: 
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private void printBoxOffice(List<Boxoffice> list) {
		System.out.println("================== 조회 건수 총 :" +list.size()  +"건 ===================");
		for(Boxoffice item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}
	
	private void commnunityMenu() {
		String menu = "========== Community Menu ==========\n"
				+ "1.영화 찜하기\n"
				+ "2.내가 찜한 목록 보기\n" 
				+ "3.영화리뷰 달기\n" 
				+ "4.전체 영화리뷰 보기\n" 
				+ "5.내가 쓴 영화리뷰 보기\n" 
				+ "0.이전 메뉴로 돌아가기\n"
				+ "----------------------------------\n"
				+ "선택 : "; 
		
		List<Boxoffice> boxList = null;
		List<Review> reviewList = null; 
		Member member = MemberController.getLoginMember();
		int memberNo = member.getmNo();
		int movieNo = 0;
		int rNo = 0;
		boolean result = false;
		Review review = null;
		
		while(true) {
			System.out.print(menu);
			int choice = Util.readIntForConsol();
			switch(choice) {
				case 1: 
					boxList = boxofficeController.getAllMvList();
					printBoxOffice(boxList);
					System.out.print("찜할 영화 번호 : ");
					movieNo = Util.readIntForConsol();
					result = communityController.setFavorite(memberNo, movieNo);
					System.out.println(result ? "성공 하였습니다.": "실패 하였습니다.");
					break;
				case 2: 
					System.out.println("-내가 찜한 영화 목록-");
					List<Favorite> list = communityController.getFavoriteListByMemberNo(memberNo);
					printFavorite(list);
					break;
				case 3: 
					boxList = boxofficeController.getAllMvList();
					printBoxOffice(boxList);
					System.out.print("리뷰 영화번호 : ");
					movieNo = Util.readIntForConsol();
					System.out.println("제목을 입력하세요.");
					String title = Util.readStrForConsol();
					System.out.println("내용을 입력하세요.");
					String content = Util.readStrForConsol();
					System.out.print("별점을 입력하세요.(1~5) : ");
					int score = Util.readIntForConsol();
					review = new Review(movieNo, memberNo, title, content, score);
					result = communityController.writeReview(review);
					System.out.println(result ? "성공 하였습니다." : "실패 하였습니다.");
					break;
				case 4:
					System.out.println("-전체 영화리뷰 목록-");
					reviewList = communityController.getReviewAllList();
					printReviewTitle(reviewList);
					System.out.print("상세 조회(No) :");
					rNo = Util.readIntForConsol();
					review = communityController.getReviewDetail(rNo);
					if(review != null) {
						System.out.println(review.toStringDetail());
					}
					break;
				case 5:
					System.out.println("-내가 쓴 영화리뷰 목록-");
					reviewList = communityController.getReviewMemberList(memberNo);
					printReviewTitle(reviewList);
					System.out.print("상세 조회(No) :");
					rNo = Util.readIntForConsol();
					review = communityController.getReviewDetail(rNo);
					System.out.println(review.toStringDetail());
					break;
				case 0 : 
					return;
				default: 
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private void printReviewTitle(List<Review> list) {
		System.out.println("================== 조회 건수 총 :" +list.size()  +"건 ===================");
		for(Review item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	private void printFavorite(List<Favorite> list) {
		System.out.println("================== 조회 건수 총 :" +list.size()  +"건 ===================");
		for(Favorite item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}
	
		
	public static void main(String[] args) {
		new BoxofficeMenu().mainMenu();
		System.out.println("---- 프로그램 종료 ----");
	}
}

