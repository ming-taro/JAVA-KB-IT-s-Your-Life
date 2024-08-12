package com.boxoffice.model.vo;

import java.util.Date;

public class Boxoffice {
	private int bNo; // PK
	private int rnum; // 순번을 출력합니다.
	private int rank; // 해당일자의 박스오피스 순위를 출력합니다.
	private int rankInten; // 전일대비 순위의 증감분을 출력합니다.
	private String rankOldandnew; // 랭킹에 신규진입여부를 출력합니다.“OLD” : 기존 , “NEW” : 신규
	private String moviecd; // 영화의 대표코드를 출력합니다.
	private String movienm; // 영화명(국문)을 출력합니다.
	private Date opendt; // 영화의 개봉일을 출력합니다.
	private long salesamt; // 해당일의 매출액을 출력합니다.
	private double salesshare; // 해당일자 상영작의 매출총액 대비 해당 영화의 매출비율을 출력합니다.
	private long salesinten; // 전일 대비 매출액 증감분을 출력합니다.
	private double saleschange; // 전일 대비 매출액 증감 비율을 출력합니다.
	private long salesacc; // 누적매출액을 출력합니다.
	private long audicnt; // 해당일의 관객수를 출력합니다.
	private long audiinten; // 전일 대비 관객수 증감분을 출력합니다.
	private double audichange; // 전일 대비 관객수 증감 비율을 출력합니다.
	private long audiacc; // 누적관객수를 출력합니다.
	private long scrncnt; // 해당일자에 상영한 스크린수를 출력합니다.
	private long showcnt; // 해당일자에 상영된 횟수를 출력합니다.
	private String boxofficeType; // 박스오피스 종류를 출력합니다.
	private String showrange; // 대상 상영기간을 출력합니다.
	private String yearweektime; // 조회일자에 해당하는 연도와 주차를 출력합니다.(YYYYIW)

	
	public Boxoffice() {
		super();
	}

	public Boxoffice(int bNo, int rnum, int rank, int rankInten, String rankOldandnew, String moviecd, String movienm,
			Date opendt, long salesamt, double salesshare, long salesinten, double saleschange, long salesacc,
			long audicnt, long audiinten, double audichange, long audiacc, long scrncnt, long showcnt,
			String boxofficeType, String showrange, String yearweektime) {
		super();
		this.bNo = bNo;
		this.rnum = rnum;
		this.rank = rank;
		this.rankInten = rankInten;
		this.rankOldandnew = rankOldandnew;
		this.moviecd = moviecd;
		this.movienm = movienm;
		this.opendt = opendt;
		this.salesamt = salesamt;
		this.salesshare = salesshare;
		this.salesinten = salesinten;
		this.saleschange = saleschange;
		this.salesacc = salesacc;
		this.audicnt = audicnt;
		this.audiinten = audiinten;
		this.audichange = audichange;
		this.audiacc = audiacc;
		this.scrncnt = scrncnt;
		this.showcnt = showcnt;
		this.boxofficeType = boxofficeType;
		this.showrange = showrange;
		this.yearweektime = yearweektime;
	}

	@Override
	public String toString() {
		return "Boxoffice [bNo=" + bNo + ", rnum=" + rnum + ", rank=" + rank + ", rankInten=" + rankInten
				+ ", rankOldandnew=" + rankOldandnew + ", moviecd=" + moviecd + ", movienm=" + movienm + ", opendt="
				+ opendt + ", salesamt=" + salesamt + ", salesshare=" + salesshare + ", salesinten=" + salesinten
				+ ", saleschange=" + saleschange + ", salesacc=" + salesacc + ", audicnt=" + audicnt + ", audiinten="
				+ audiinten + ", audichange=" + audichange + ", audiacc=" + audiacc + ", scrncnt=" + scrncnt
				+ ", showcnt=" + showcnt + ", boxofficeType=" + boxofficeType + ", showrange=" + showrange
				+ ", yearweektime=" + yearweektime + "]";
	}

	public String toStringForConsole() {
		return "no:" + bNo + ", 순위:" + rank + ", 이름:" + movienm	+ ", 주간:" + yearweektime
				+ ", 신규여부:" + rankOldandnew + ", 랭크변화:" + rankInten + ", 개봉일:"
				+ opendt + ", salesamt:" + salesamt + ", salesshare:" + salesshare + ", salesinten:" + salesinten
				+ ", saleschange:" + saleschange + ", salesacc:" + salesacc + ", audicnt:" + audicnt + ", audiinten:"
				+ audiinten + ", audichange:" + audichange + ", audiacc:" + audiacc + ", scrncnt:" + scrncnt
				+ ", showcnt:" + showcnt + ", boxofficeType:" + boxofficeType + ", showrange:" + showrange;
			
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRankInten() {
		return rankInten;
	}

	public void setRankInten(int rankInten) {
		this.rankInten = rankInten;
	}

	public String getRankOldandnew() {
		return rankOldandnew;
	}

	public void setRankOldandnew(String rankOldandnew) {
		this.rankOldandnew = rankOldandnew;
	}

	public String getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(String moviecd) {
		this.moviecd = moviecd;
	}

	public String getMovienm() {
		return movienm;
	}

	public void setMovienm(String movienm) {
		this.movienm = movienm;
	}

	public Date getOpendt() {
		return opendt;
	}

	public void setOpendt(Date opendt) {
		this.opendt = opendt;
	}

	public long getSalesamt() {
		return salesamt;
	}

	public void setSalesamt(long salesamt) {
		this.salesamt = salesamt;
	}

	public double getSalesshare() {
		return salesshare;
	}

	public void setSalesshare(double salesshare) {
		this.salesshare = salesshare;
	}

	public long getSalesinten() {
		return salesinten;
	}

	public void setSalesinten(long salesinten) {
		this.salesinten = salesinten;
	}

	public double getSaleschange() {
		return saleschange;
	}

	public void setSaleschange(double saleschange) {
		this.saleschange = saleschange;
	}

	public long getSalesacc() {
		return salesacc;
	}

	public void setSalesacc(long salesacc) {
		this.salesacc = salesacc;
	}

	public long getAudicnt() {
		return audicnt;
	}

	public void setAudicnt(long audicnt) {
		this.audicnt = audicnt;
	}

	public long getAudiinten() {
		return audiinten;
	}

	public void setAudiinten(long audiinten) {
		this.audiinten = audiinten;
	}

	public double getAudichange() {
		return audichange;
	}

	public void setAudichange(double audichange) {
		this.audichange = audichange;
	}

	public long getAudiacc() {
		return audiacc;
	}

	public void setAudiacc(long audiacc) {
		this.audiacc = audiacc;
	}

	public long getScrncnt() {
		return scrncnt;
	}

	public void setScrncnt(long scrncnt) {
		this.scrncnt = scrncnt;
	}

	public long getShowcnt() {
		return showcnt;
	}

	public void setShowcnt(long showcnt) {
		this.showcnt = showcnt;
	}

	public String getBoxofficeType() {
		return boxofficeType;
	}

	public void setBoxofficeType(String boxofficeType) {
		this.boxofficeType = boxofficeType;
	}

	public String getShowrange() {
		return showrange;
	}

	public void setShowrange(String showrange) {
		this.showrange = showrange;
	}

	public String getYearweektime() {
		return yearweektime;
	}

	public void setYearweektime(String yearweektime) {
		this.yearweektime = yearweektime;
	}

}