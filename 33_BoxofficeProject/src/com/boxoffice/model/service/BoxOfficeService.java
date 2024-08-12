package com.boxoffice.model.service;


import static com.boxoffice.common.JDBCTemplate.commit;
import static com.boxoffice.common.JDBCTemplate.openConnection;
import static com.boxoffice.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.boxoffice.model.dao.BoxOfficeDao;
import com.boxoffice.model.vo.Boxoffice;

public class BoxOfficeService {
	private BoxOfficeDao dao = new BoxOfficeDao();
	private Connection conn = null;
	
	public BoxOfficeService() {
		conn = openConnection();
	}

	public List<Boxoffice> selectAll() {
		return dao.selectAll(conn);
	}
	
	public Boxoffice selectOne(int bNo) {
		return dao.selectOne(conn, bNo);
	}
	
	public List<Boxoffice> selectByMvName(String movieName) {
		return dao.selectByMvName(conn, movieName);
	}
	
	public List<Boxoffice> selectByYearweekTime(String yearweekTime) {
		return dao.selectByYearweekTime(conn, yearweekTime);
	}
	
	public int insert(Boxoffice boxoffice) {
		int result = dao.insert(conn, boxoffice);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}


}
