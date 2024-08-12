package com.boxoffice.model.service;

import static com.boxoffice.common.JDBCTemplate.commit;
import static com.boxoffice.common.JDBCTemplate.openConnection;
import static com.boxoffice.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.boxoffice.model.dao.FavoriteDao;
import com.boxoffice.model.vo.Favorite;

public class FavoriteService {
	private FavoriteDao dao = new FavoriteDao();
	private Connection conn = null;

	public FavoriteService() {
		conn = openConnection();
	}

	public List<Favorite> selectAll() {
		return dao.selectAll(conn);
	}

	public List<Favorite> selectByMno(int memberNo) {
		return dao.selectByMno(conn, memberNo);
	}

	public List<Favorite> selectByBno(int boxofficeNo) {
		return dao.selectByBno(conn, boxofficeNo);
	}

	public int insert(Favorite fovorite) {
		int result = dao.insert(conn, fovorite);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int delete(Favorite fovorite) {
		int result = dao.delete(conn, fovorite);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
