package com.boxoffice.model.dao;


import static com.boxoffice.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.boxoffice.common.JDBCTemplate;
import com.boxoffice.model.vo.Boxoffice;
import com.boxoffice.model.vo.Review;
import com.boxoffice.model.vo.Member;

public class ReviewDao {

	public List<Review> selectAll(Connection conn) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT R.RNO, R.BNO, R.MNO, R.TITLE, R.SCORE, R.CREATE_DATE, M.ID, B.MOVIENM "
					+ "FROM REVIEW_BOXOFFICE R "
					+ "JOIN MEMBER M ON (R.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (R.BNO = B.BNO) "
					+ "ORDER BY R.RNO";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int rNo  = rs.getInt("RNO");
				int bNo  = rs.getInt("BNO");
				int mNo  = rs.getInt("MNO");
				String title  = rs.getString("TITLE");
				int score  = rs.getInt("SCORE");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				Member member = new Member();
				member.setId(rs.getString("ID"));
				Boxoffice movieInfo = new Boxoffice();
				movieInfo.setMovienm(rs.getString("MOVIENM"));
				Review r = new Review(rNo, bNo, mNo, title, null, score, createDate, member, movieInfo);
				list.add(r);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public List<Review> selectByMNo(Connection conn, int mno) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT R.RNO, R.BNO, R.MNO, R.TITLE, R.CONTENT, R.SCORE, R.CREATE_DATE, M.ID, B.MOVIENM "
					+ "FROM REVIEW_BOXOFFICE R "
					+ "JOIN MEMBER M ON (R.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (R.BNO = B.BNO) "
					+ "WHERE R.MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			
			while (rs.next() == true) {
				int rNo  = rs.getInt("RNO");
				int bNo  = rs.getInt("BNO");
				mno  = rs.getInt("MNO");
				String title  = rs.getString("TITLE");
				String content  = rs.getString("CONTENT");
				int score  = rs.getInt("SCORE");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				Member member = new Member();
				member.setId(rs.getString("CREATE_DATE"));
				Boxoffice movieInfo = new Boxoffice();
				movieInfo.setMovienm(rs.getString("MOVIENM"));
				Review r = new Review(rNo, bNo, mno, title, content, score, createDate, member, movieInfo);
				list.add(r);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public List<Review> selectByBNo(Connection conn, int bno) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT R.RNO, R.BNO, R.MNO, R.TITLE, R.CONTENT, R.SCORE, R.CREATE_DATE, M.ID, B.MOVIENM "
					+ "FROM REVIEW_BOXOFFICE R "
					+ "JOIN MEMBER M ON (R.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (R.BNO = B.BNO) "
					+ "WHERE R.BNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while (rs.next() == true) {
				int rno  = rs.getInt("RNO");
			    bno 	 = rs.getInt("BNO");
				int mno  = rs.getInt("MNO");
				String title  = rs.getString("TITLE");
				String content  = rs.getString("CONTENT");
				int score  = rs.getInt("SCORE");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				Member member = new Member();
				member.setId(rs.getString("ID"));
				Boxoffice movieInfo = new Boxoffice();
				movieInfo.setMovienm(rs.getString("MOVIENM"));
				Review r = new Review(rno, bno, mno, title, content, score, createDate, member, movieInfo);
				list.add(r);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public Review selectOneDetail(Connection conn, int rNo) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT B.*, M.*, R.*  "  
					+ "FROM REVIEW_BOXOFFICE R "
					+ "JOIN MEMBER M ON (R.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (R.BNO = B.BNO) "
					+ "WHERE R.RNO = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				int count = 1;
				int bNo 					= rs.getInt(count++);
				int rnum                    = rs.getInt(count++);
				int rank                    = rs.getInt(count++);
				int rankInten               = rs.getInt(count++);
				String rankOldandnew        = rs.getString(count++);
				String moviecd              = rs.getString(count++);
				String movienm              = rs.getString(count++);
				Date opendt  				= rs.getDate(count++);
				long salesamt                = rs.getLong(count++);
				double salesshare            = rs.getDouble(count++);
				long salesinten              = rs.getLong(count++);
				double saleschange           = rs.getDouble(count++);
				long salesacc                = rs.getLong(count++);
				long audicnt                 = rs.getLong(count++);
				long audiinten               = rs.getLong(count++);
				double audichange            = rs.getDouble(count++);
				long audiacc                 = rs.getLong(count++);
				long scrncnt                 = rs.getLong(count++);
				long showcnt                 = rs.getLong(count++);
				String boxofficeType        = rs.getString(count++);
				String showrange            = rs.getString(count++);
				String yearweektime         = rs.getString(count++);
				Boxoffice movieInfo = new Boxoffice(bNo, rnum, rank, rankInten, rankOldandnew, moviecd, movienm, opendt, salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange, audiacc, scrncnt, showcnt, boxofficeType, showrange, yearweektime);
				
				int mno = 		rs.getInt(count++);
				String id = 	rs.getString(count++);
				String password = rs.getString(count++);
				String name 	= rs.getString(count++);
				Member member = new Member(mno, id, password, name);
				
				int rNo2  = rs.getInt(count++);
				int bNo2  = rs.getInt(count++);
				int mNo2  = rs.getInt(count++);
				String title  = rs.getString(count++);
				String content  = rs.getString(count++);
				int score  = rs.getInt(count++);
				Date createDate  = new Date(rs.getTimestamp(count++).getTime());
				review = new Review(rNo2, bNo2, mNo2, title, content, score, createDate, member, movieInfo);
			}
			
			return review;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public int insert(Connection conn, Review review) {
		try {
			String sql = "INSERT INTO REVIEW_BOXOFFICE(RNO, BNO, MNO, TITLE, CONTENT, SCORE) "
					+ "VALUES(0, ?, ?, ?, ?, ?)";
					
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, review.getbNo());
			pstmt.setInt(2, review.getmNo());
			pstmt.setString(3, review.getTitle());
			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getScore());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(Connection conn, int rNo) {
		try {
			String sql = "DELETE FROM REVIEW_BOXOFFICE WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setInt(1, rNo);
			
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
		
		Review r = new Review(1, 1, "재미없다", "이게 뭐야", 5);
		int result = new ReviewDao().insert(conn, r);
		System.out.println(result);

		
		List<Review> list = new ReviewDao().selectAll(conn);
		
		 result = new ReviewDao().delete(conn, list.get(0).getrNo());
		System.out.println(result);
		
		
		list = new ReviewDao().selectAll(conn);
		for(Review info : list) {
			System.out.println(info.toString());
		}
		System.out.println();
		
		
		
		Review review = new ReviewDao().selectOneDetail(conn, 2);
		System.out.println(review);
		
		list = new ReviewDao().selectByMNo(conn, 1);
		for(Review info : list) {
			System.out.println(info.toString());
		}
		System.out.println();
	}
	
	
}
