package com.boxoffice.model.dao;

import static com.boxoffice.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.boxoffice.common.JDBCTemplate;
import com.boxoffice.model.vo.Boxoffice;

public class BoxOfficeDao {
	
	public List<Boxoffice> selectAll(Connection conn) {
		List<Boxoffice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM WEEKLY_BOXOFFICE ORDER BY YEARWEEKTIME, BOXOFFICE_RANK";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int bNo = rs.getInt(count++);
				int rnum = rs.getInt(count++);
				int rank = rs.getInt(count++);
				int rankInten = rs.getInt(count++);
				String rankOldandnew = rs.getString(count++);
				String moviecd = rs.getString(count++);
				String movienm = rs.getString(count++);
				Date opendt = rs.getDate(count++);
				long salesamt = rs.getLong(count++);
				double salesshare = rs.getDouble(count++);
				long salesinten = rs.getLong(count++);
				double saleschange = rs.getDouble(count++);
				long salesacc = rs.getLong(count++);
				long audicnt = rs.getLong(count++);
				long audiinten = rs.getLong(count++);
				double audichange = rs.getDouble(count++);
				long audiacc = rs.getLong(count++);
				long scrncnt = rs.getLong(count++);
				long showcnt = rs.getLong(count++);
				String boxofficeType = rs.getString(count++);
				String showrange = rs.getString(count++);
				String yearweektime = rs.getString(count++);

				Boxoffice info = new Boxoffice(bNo, rnum, rank, rankInten, rankOldandnew, moviecd, movienm, opendt,
						salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange,
						audiacc, scrncnt, showcnt, boxofficeType, showrange, yearweektime);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public Boxoffice selectOne(Connection conn, int bNo) {
		Boxoffice info = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM WEEKLY_BOXOFFICE WHERE bNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int bNo2 = rs.getInt(count++);
				int rnum = rs.getInt(count++);
				int rank = rs.getInt(count++);
				int rankInten = rs.getInt(count++);
				String rankOldandnew = rs.getString(count++);
				String moviecd = rs.getString(count++);
				String movienm = rs.getString(count++);
				Date opendt = rs.getDate(count++);
				long salesamt = rs.getLong(count++);
				double salesshare = rs.getDouble(count++);
				long salesinten = rs.getLong(count++);
				double saleschange = rs.getDouble(count++);
				long salesacc = rs.getLong(count++);
				long audicnt = rs.getLong(count++);
				long audiinten = rs.getLong(count++);
				double audichange = rs.getDouble(count++);
				long audiacc = rs.getLong(count++);
				long scrncnt = rs.getLong(count++);
				long showcnt = rs.getLong(count++);
				String boxofficeType = rs.getString(count++);
				String showrange = rs.getString(count++);
				String yearweektime = rs.getString(count++);

				info = new Boxoffice(bNo2, rnum, rank, rankInten, rankOldandnew, moviecd, movienm, opendt, salesamt,
						salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange, audiacc, scrncnt,
						showcnt, boxofficeType, showrange, yearweektime);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return info;
	}

	public List<Boxoffice> selectByMvName(Connection conn, String movieName) {
		List<Boxoffice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM WEEKLY_BOXOFFICE WHERE movieNm LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + movieName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int bNo = rs.getInt(count++);
				int rnum = rs.getInt(count++);
				int rank = rs.getInt(count++);
				int rankInten = rs.getInt(count++);
				String rankOldandnew = rs.getString(count++);
				String moviecd = rs.getString(count++);
				String movienm = rs.getString(count++);
				Date opendt = rs.getDate(count++);
				long salesamt = rs.getLong(count++);
				double salesshare = rs.getDouble(count++);
				long salesinten = rs.getLong(count++);
				double saleschange = rs.getDouble(count++);
				long salesacc = rs.getLong(count++);
				long audicnt = rs.getLong(count++);
				long audiinten = rs.getLong(count++);
				double audichange = rs.getDouble(count++);
				long audiacc = rs.getLong(count++);
				long scrncnt = rs.getLong(count++);
				long showcnt = rs.getLong(count++);
				String boxofficeType = rs.getString(count++);
				String showrange = rs.getString(count++);
				String yearweektime = rs.getString(count++);

				Boxoffice info = new Boxoffice(bNo, rnum, rank, rankInten, rankOldandnew, moviecd, movienm, opendt,
						salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange,
						audiacc, scrncnt, showcnt, boxofficeType, showrange, yearweektime);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<Boxoffice> selectByYearweekTime(Connection conn, String yearweekTime) {
		List<Boxoffice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM WEEKLY_BOXOFFICE WHERE YEARWEEKTIME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, yearweekTime);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int bNo = rs.getInt(count++);
				int rnum = rs.getInt(count++);
				int rank = rs.getInt(count++);
				int rankInten = rs.getInt(count++);
				String rankOldandnew = rs.getString(count++);
				String moviecd = rs.getString(count++);
				String movienm = rs.getString(count++);
				Date opendt = rs.getDate(count++);
				long salesamt = rs.getLong(count++);
				double salesshare = rs.getDouble(count++);
				long salesinten = rs.getLong(count++);
				double saleschange = rs.getDouble(count++);
				long salesacc = rs.getLong(count++);
				long audicnt = rs.getLong(count++);
				long audiinten = rs.getLong(count++);
				double audichange = rs.getDouble(count++);
				long audiacc = rs.getLong(count++);
				long scrncnt = rs.getLong(count++);
				long showcnt = rs.getLong(count++);
				String boxofficeType = rs.getString(count++);
				String showrange = rs.getString(count++);
				String yearweektime = rs.getString(count++);

				Boxoffice info = new Boxoffice(bNo, rnum, rank, rankInten, rankOldandnew, moviecd, movienm, opendt,
						salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange,
						audiacc, scrncnt, showcnt, boxofficeType, showrange, yearweektime);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int insert(Connection conn, Boxoffice boxoffice) {
		try {
			String sql = "INSERT INTO "
					+ "WEEKLY_BOXOFFICE(BNO, RNUM, BOXOFFICE_RANK, rankInten, rankOldAndNew, movieCd, movieNm, "
					+ "                 openDt, salesAmt, salesShare, salesInten, salesChange, salesAcc, "
					+ "                 audiCnt, audiInten, audiChange, audiAcc, scrnCnt, showCnt, "
					+ "                 BOXOFFICETYPE, SHOWRANGE, YEARWEEKTIME) " 
					+ "VALUES(0, "
					+ "		   ?, ?, ?, ?, ?, ?, ?, ?, " 
					+ "        ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "        ?, ?, ?, ?, ?) ";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, boxoffice.getRnum());
			pstmt.setInt(cnt++, boxoffice.getRank());
			pstmt.setInt(cnt++, boxoffice.getRankInten());
			pstmt.setString(cnt++, boxoffice.getRankOldandnew());
			pstmt.setString(cnt++, boxoffice.getMoviecd());
			pstmt.setString(cnt++, boxoffice.getMovienm());
			pstmt.setDate(cnt++, new java.sql.Date(boxoffice.getOpendt().getTime()));
			pstmt.setLong(cnt++, boxoffice.getSalesamt());
			pstmt.setDouble(cnt++, boxoffice.getSalesshare());
			pstmt.setLong(cnt++, boxoffice.getSalesinten());
			pstmt.setDouble(cnt++, boxoffice.getSaleschange());
			pstmt.setDouble(cnt++, boxoffice.getSalesacc());
			pstmt.setLong(cnt++, boxoffice.getAudicnt());
			pstmt.setDouble(cnt++, boxoffice.getAudiinten());
			pstmt.setDouble(cnt++, boxoffice.getAudichange());
			pstmt.setLong(cnt++, boxoffice.getAudiacc());
			pstmt.setLong(cnt++, boxoffice.getScrncnt());
			pstmt.setLong(cnt++, boxoffice.getShowcnt());
			pstmt.setString(cnt++, boxoffice.getBoxofficeType());
			pstmt.setString(cnt++, boxoffice.getShowrange());
			pstmt.setString(cnt++, boxoffice.getYearweektime());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = JDBCTemplate.openConnection();
		List<Boxoffice> list = new BoxOfficeDao().selectAll(conn);
		for (Boxoffice info : list) {
			System.out.println(info);
		}
		Date date = new Date();
		Boxoffice info = new Boxoffice(10, 2, 2, 0, "OLD", "20112207", "미션임파서블:고스트프로토콜2", date, 7840509500L, 35.8,
				-1706758500, -17.9, 40541108500L, 1007683, -234848, -18.9, 5328435, 697, 9677, "주말 박스오피스",
				"20111230~20120101", "201152");
		int result = new BoxOfficeDao().insert(conn, info);
		conn.commit();
		System.out.println(result);
		list = new BoxOfficeDao().selectAll(conn);
		for (Boxoffice info2 : list) {
			System.out.println(info2);
		}
	}
}
