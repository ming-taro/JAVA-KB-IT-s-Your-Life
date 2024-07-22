package com.multi.ex01.statement;

import java.sql.*;

public class StatementBasic {
    // DB 연결을 유지하는 객체
    public static Connection conn = null;
    // SQL을 담는 객체
    public static Statement stmt = null;
    // select문의 결과 값을 받는 객체
    public static ResultSet rs = null;

    public static String driverClass = "com.mysql.cj.jdbc.Driver";
    //public static String url = "jdbc:mysql://localhost:3306/jdbc"; // localhost 자기자신
    public static String url = "jdbc:mysql://127.0.0.1:3306/jdbc"; // 127.0.0.1 = loofback IP, 3306 = 포트주소
    public static String user = "root";
    public static String password = "0000";

    public static void main(String[] args) {
        try {
            // 1. 클래스 드라이버 등록 (최초 한번만 필요, 최신버전들은 거의 필요가 없다.)
            Class.forName(driverClass);
            System.out.println("1. 드라이버 등록 성공!");

            // 2. Connection=(DB 연결객체) 객체 생성
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("2. DB 접속 및 로그인 성공!");

            // 3. 자동 커밋여부 해제 : default-true, false로 설정해야 해제가 된다.
            // -> 사용자가 트랜잭션을 제어한다.
            conn.setAutoCommit(false);

            // 4. conn 객체를 통해 DB SQL을 요청하는 statement를 생성
            stmt = conn.createStatement();
            System.out.println("3. createStatement 성공 ");

            // 5. 필요한 쿼리를 작성
            select();

            insert();
            select();

            update();
            select();

            delete();
            select();

            // 6. commit이 필요한 경우 commit
//            conn.commit(); // 수동으로 commit 명령을 내리는 방법
            conn.rollback(); // 기존 commit 이후로 실행된 SQL을 되돌리는 방법
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 생성됬던 객체 Close
            // -> 생성된 객체의 역순으로 Close 수행
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                System.out.println("6. Close 성공!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void select() throws SQLException {
        System.out.println("SELECT문 시작!");

        String sql = "select * from member"; // 쿼리 끝에 세미콜론이 붙으면 에러 발생할수 있음!
        rs = stmt.executeQuery(sql); // DB sql을 날리는 명령
        // rs : DB 쿼리 실행 결과 담는 객체

        // next : 커서 넘겨서 다음 행으로 이동하는 명령, default는 커서 0, 끝난 경우는 false를 반환
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();

            // 1. index를 통해 result set을 가져오는 방법
            //   -> 쓰면 안된다. 추천하지 않음!!
            //   desc를 통한 컬럼의 순서를 알고 써야하는 문법
//            sb.append(rs.getInt(1) + ", ");
//            sb.append(rs.getString(2) + ", ");
//            sb.append(rs.getString(3) + ", ");
//            sb.append(rs.getString(4) + ", ");

            // 2. index로 db값 가져오는 방법, i 활용
            //int i = 1;
            //sb.append(rs.getInt(i++) + ", "); // index로 가져오는 방법
            //sb.append(rs.getString(i++) + ", ");
            //sb.append(rs.getString(i++) + ", ");
            //sb.append(rs.getString(i++) + ", ");
            // index로 가져올때는 table의 컬럼 순서에 따라 반환된다.

            // 3. 컬럼명으로 데이터를 가져오는 방법 ★★★★★ FM, 정석적인 방법
            // - 컬럼명의 경우 대소문자를 가리지 않고 가져올수 있음
            // getInt/getLong : 숫자로 가져올때
            // getDouble : 실수를 가져올때
            // getDate : 날짜로만 이뤄진 데이터 가져올때
            //           만일 시간이 있는데, Date로 가져온 경우 time부분이 손실된다.
            // getTimestamp : 날짜와 시간을 모두 갖는 데이터를 가져올때
            sb.append(rs.getLong("mno") + ",");           // INT PRIMARY KEY auto_increment,
            sb.append(rs.getString("id") + ",");          // VARCHAR(20) NOT NULL unique,
            sb.append(rs.getString("password") + ",");    // VARCHAR(20) NOT NULL,
            sb.append(rs.getString("name") + ",");        // VARCHAR(20) NOT NULL,
            sb.append(rs.getString("gender") + ",");      // VARCHAR(1) CHECK(GENDER IN ('M','F')),
            sb.append(rs.getDouble("age") + ",");         // INT NOT NULL,
            sb.append(rs.getString("email") + ",");       // VARCHAR(30),
            sb.append(rs.getString("phone") + ",");       // CHAR(13),
            sb.append(rs.getString("address") + ",");     // VARCHAR(200),
            sb.append(rs.getString("hobby") + ",");       // VARCHAR(100),
            sb.append(rs.getDate("birthday") + ",");    // DATE,
            sb.append(rs.getTimestamp("enrolldate") + ",");  // DATETIME DEFAULT NOW()

            System.out.println(sb.toString());
        }
        System.out.println("SELECT문 종료!\n");
    }

    private static void insert() throws SQLException {
        System.out.println("insert문 시작!");

        // 텍스가 너무 긴 경우 중간에 줄넘김 가능
        // ※ 주의 쿼리 끝라인에 공백 추가할 것!
        String sql = "INSERT INTO member " +
                "VALUES(default, 'test6','4321','안길동','M', " +
                "28, 'ahn@test.com', '01017778888','서울시 강남구 역삼동 10-30', " +
                "'운동,등산,기타','1992-04-15',default) ";
        int result = stmt.executeUpdate(sql); // result : 실행된 행의 갯수

        if (result > 0) {
            System.out.println("insert 성공, 결과 : " + result);
        } else {
            System.out.println("insert 실패!");
        }
        System.out.println("insert문 종료!");
    }


    private static void update() throws SQLException {
        System.out.println("update 시작!!");

        String sql = "update member set name = '이길동2222' where id = 'test6'";
        int result = stmt.executeUpdate(sql);

        if (result > 0) { // 0보다 커야 성공!
            System.out.println("update 성공!");
        } else {
            System.out.println("update 실패.");
        }

        System.out.println("update 종료\n");
    }

    private static void delete() throws SQLException {
        System.out.println("delete 시작!!");
        String sql = "delete from member where id = 'test6'";
        int result = stmt.executeUpdate(sql);

        if (result > 0) { // 0보다 커야 성공!
            System.out.println("delete 성공!");
        } else {
            System.out.println("delete 실패.");
        }

        System.out.println("delete 종료\n");
    }
}