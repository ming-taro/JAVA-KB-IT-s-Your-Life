package com.boxoffice.model.vo;

import java.util.Date;

import com.boxoffice.common.Util;

public class Review {
	private int rNo;
	private int bNo;
	private int mNo;
	private String title;
	private String content;
	private int score;
	private Date createDate; // REVIEW_BOXOFFICE
	private Member member;
	private Boxoffice movieInfo;

	public Review() {
		super();
	}

	// 리뷰의 풀 생성자
	public Review(int rNo, int bNo, int mNo, String title, String content, int score, Date createDate, Member member,
			Boxoffice movieInfo) {
		super();
		this.rNo = rNo;
		this.bNo = bNo;
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.score = score;
		this.createDate = createDate;
		this.member = member;
		this.movieInfo = movieInfo;
	}
	
	
	// 리뷰 작성시의 생성자
	public Review(int bNo, int mNo, String title, String content, int score) {
		super();
		this.bNo = bNo;
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Review [rNo=" + rNo + ", bNo=" + bNo + ", mNo=" + mNo + ", title=" + title + ", content=" + content
				+ ", score=" + score + ", createDate=" + createDate + ", member=" + member + ", movieInfo=" + movieInfo
				+ "]";
	}
	
	public String toStringForConsole() {
		return "No:" + rNo +" 제목:" + title + " 영화:" + movieInfo.getMovienm() + 
				" 평점:" + score +  " 작성자:"+member.getId() + " 작성일:" + Util.getDateFormat(createDate);
	}
	
	public String toStringDetail() {
		return "No : " + rNo 
				+ "\n제목 : " + title 
				+ "\n영화 : " + movieInfo.getMovienm() + ", 순위 : " + movieInfo.getRank()
				+ "\n내용 : " + content  
				+ "\n작성일 : " + Util.getDateFormat(createDate)
				+ "\n작성자 : " + member.getId()  
				+ "\n평점 : " + score 
				+ "\n";
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Boxoffice getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(Boxoffice movieInfo) {
		this.movieInfo = movieInfo;
	}

}