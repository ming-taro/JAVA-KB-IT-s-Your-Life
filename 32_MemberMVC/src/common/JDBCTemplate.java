package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

// jdbc 공통부 코드
public class JDBCTemplate {
	// 공통부 코드를 작성
	// 1. JDBC 관련 드라이버 로드 
	// 2. connection 생성
	// 3. 객체들 close
	
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			Properties prop = new Properties(); // 컬랙션에서 배운 Map중 하나
			FileReader fr = new FileReader("32_MemberMVC/resources/data-source.properties");
			prop.load(fr);
			fr.close();
			driverClass = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection openConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // 자동 커밋 해제
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null && pstmt.isClosed() == false) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && rs.isClosed() == false) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
