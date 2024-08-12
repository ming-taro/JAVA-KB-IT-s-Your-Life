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
import com.boxoffice.model.vo.Favorite;

public class FavoriteDao {

	public List<Favorite> selectAll(Connection conn) {
		List<Favorite> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT F.BNO, F.MNO, F.CREATE_DATE, M.ID, B.MOVIENM "
					+ "FROM FAVORITE_BOXOFFICE F "
					+ "JOIN MEMBER M ON (F.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (B.BNO = F.BNO) ";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int bNo = rs.getInt("BNO");
				int mNo = rs.getInt("MNO");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				String memberId = rs.getString("ID");
				String movieNm = rs.getString("MOVIENM");
				Favorite info = new Favorite(bNo, mNo, createDate, memberId, movieNm);
				list.add(info);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public List<Favorite> selectByMno(Connection conn, int mno) {
		List<Favorite> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT F.BNO, F.MNO, F.CREATE_DATE, M.ID, B.MOVIENM  "
					+ "FROM FAVORITE_BOXOFFICE F "
					+ "JOIN MEMBER M ON (F.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (B.BNO = F.BNO) "
					+ "WHERE F.MNO = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int bNo = rs.getInt("BNO");
				int mNo = rs.getInt("MNO");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				String memberId = rs.getString("ID");
				String movieNm = rs.getString("MOVIENM");
				Favorite info = new Favorite(bNo, mNo, createDate, memberId, movieNm);
				list.add(info);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public List<Favorite> selectByBno(Connection conn, int boxofficeNo) {
		List<Favorite> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			String sql = "SELECT F.BNO, F.MNO, F.CREATE_DATE, M.ID, B.MOVIENM  "
					+ "FROM FAVORITE_BOXOFFICE F "
					+ "JOIN MEMBER M ON (F.MNO = M.MNO) "
					+ "JOIN WEEKLY_BOXOFFICE B ON (B.BNO = F.BNO) "
					+ "WHERE F.BNO = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boxofficeNo);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int bNo = rs.getInt("BNO");
				int mNo = rs.getInt("MNO");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				String memberId = rs.getString("ID");
				String movieNm = rs.getString("MOVIENM");
				Favorite info = new Favorite(bNo, mNo, createDate, memberId, movieNm);
				list.add(info);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public int insert(Connection conn, Favorite fovorite) {
		try {
			String sql = "INSERT INTO FAVORITE_BOXOFFICE(BNO, MNO) VALUES(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, fovorite.getbNo());
			pstmt.setInt(2, fovorite.getmNo());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(Connection conn, Favorite fovorite) {
		try {
			String sql = "DELETE FROM FAVORITE_BOXOFFICE WHERE BNO = ? AND MNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, fovorite.getbNo());
			pstmt.setInt(2, fovorite.getmNo());

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

		int result = new FavoriteDao().delete(conn, new Favorite(1, 1));
		System.out.println(result);

		result = new FavoriteDao().insert(conn, new Favorite(1, 1));
		System.out.println(result);

		List<Favorite> list = new FavoriteDao().selectAll(conn);
		for (Favorite info : list) {
			System.out.println(info.toString());
		}
		System.out.println();

		list = new FavoriteDao().selectByBno(conn, 1);
		for (Favorite info : list) {
			System.out.println(info.toString());
		}
		System.out.println();

		list = new FavoriteDao().selectByMno(conn, 2);
		for (Favorite info : list) {
			System.out.println(info.toString());
		}
		System.out.println();
	}

}
