package com.boxoffice.model.service;

import static com.boxoffice.common.JDBCTemplate.commit;
import static com.boxoffice.common.JDBCTemplate.openConnection;
import static com.boxoffice.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.boxoffice.model.dao.ReviewDao;
import com.boxoffice.model.vo.Review;

public class ReviewService {
	private ReviewDao dao = new ReviewDao();
	private Connection conn = null;

	public ReviewService() {
		conn = openConnection();
	}

	public List<Review> selectAll() {
		return dao.selectAll(conn);
	}

	public Review selectOneDetail(int rNo) {
		return dao.selectOneDetail(conn, rNo);
	}

	public List<Review> selectByMno(int mon) {
		return dao.selectByMNo(conn, mon);
	}

	public List<Review> selectByBNo(int boxofficeNo) {
		return dao.selectByBNo(conn, boxofficeNo);
	}
	

	public int insert(Review review) {
		int result = dao.insert(conn, review);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int delete(int rNo) {
		int result = dao.delete(conn, rNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
