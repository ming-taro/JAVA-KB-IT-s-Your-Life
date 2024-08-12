package com.boxoffice.model.vo;

import java.util.Date;

import com.boxoffice.common.Util;

// 즐겨찾기 VO : 테이블 정보의 1:1 vs DTO 테이블 정보 + 객체로 존재해야할 추가 데이터
// -> DTO 성격으로 설계해야한다. 실제 보여줄 UI 기준으로 데이터를 추가적인 공간 확보 필요, ex) Join 됬을 때 필요한 추가 정보
public class Favorite {
	private int mNo;
	private int bNo;
	private Date createDate;
	private String memberId; // Table과 1:1 맵핑되지 않는 멤버변수-컬럼명
	private String movieNm; // 영화이름


	public Favorite() {
		super();
	}

	public Favorite(int bNo, int mNo) {
		super();
		this.bNo = bNo;
		this.mNo = mNo;
	}

	public Favorite(int mNo, int bNo, Date createDate, String memberId, String movieNm) {
		super();
		this.mNo = mNo;
		this.bNo = bNo;
		this.createDate = createDate;
		this.memberId = memberId;
		this.movieNm = movieNm;
	}


	@Override
	public String toString() {
		return "Favorite [bNo=" + bNo + ", mNo=" + mNo + ", createDate=" + Util.getDateFormat(createDate)  + ", memberId=" + memberId
				+ ", movieNm=" + movieNm + "]";
	}
	
	public String toStringForConsole() {
		return 	"제목 : " + movieNm + ", 생성일 : " + Util.getDateFormat(createDate)  + ", id=" + memberId;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}

// 즐겨찾기 목록
// -> 1, 2, 2023-12-04?
// -> 본인, 해리포터와 마법사의 돌, 2023-12-04
// -> 본인, 해리포터와 불의잔, 2023-12-04
