package com.multi.ex02.preparedstatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {
    private static Connection conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet result = null;

    private static String dirverClass = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jdbc";
    private static String user = "root";
    private static String password = "0000";

    public static void main(String[] args) {
        try {
            Class.forName(dirverClass);
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            List<Member> list = selectAll();
            print(list);

            System.out.println("select one 호출");
            String id = "user1";
            Member member = selectOne(id);
            System.out.println(member);
            System.out.println("select one 끝");

            Calendar calendar = Calendar.getInstance();
            calendar.set(2000, 8, 4);
            member = new Member(0, "test6", "1234", "박밍", "M", 26, "hera@test.com", "01012345678",
                    "서울시 광진구", "농구", calendar.getTime(), null);

            insert(member);
            list = selectAll();
            print(list);

            update(member.getId(), "김길동");
            list = selectAll();
            print(list);

            delete(member.getId());
            list = selectAll();
            print(list);

            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void print(List<Member> list) {
        System.out.println("---------------------------MEMBER---------------------------");
        list.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------\n");
    }

    private static void insert(Member member) throws SQLException {
        System.out.println("Insert 시작!");
        String sql = "INSERT INTO MEMBER VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
        pstm = conn.prepareStatement(sql);

        int count = 1;
        pstm.setString(count++, member.getId());
        pstm.setString(count++, member.getPassword());
        pstm.setString(count++, member.getName());
        pstm.setString(count++, member.getGender());
        pstm.setInt(count++, member.getAge());
        pstm.setString(count++, member.getEmail());
        pstm.setString(count++, member.getPhone());
        pstm.setString(count++, member.getAddress());
        pstm.setString(count++, member.getHobby());
        pstm.setDate(count++, new java.sql.Date(member.getBirthday().getTime()));

        int result = pstm.executeUpdate();

        if (result > 0) {
            System.out.println("insert 성공");
        } else {
            System.out.println("insert 실패");
        }
        System.out.println("Insert 종료\n");
    }

    private static void update(String id, String name) throws SQLException {
        System.out.println("Update 시작!!");
        String sql = "UPDATE MEMBER SET name = ? where id = ?";

        pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2, id);

        int result = pstm.executeUpdate();
        if (result > 0) {
            System.out.println("Update 성공!");
        } else {
            System.out.println("Update 실패!");
        }
        System.out.println("Update 종료\n");
    }

    private static void delete(String id) throws SQLException {
        System.out.println("delete 시작!!");
        String sql = "DELETE FROM MEMBER WHERE id = ?";

        pstm = conn.prepareStatement(sql);
        pstm.setString(1, id);

        int result = pstm.executeUpdate();
        if (result > 0) {
            System.out.println("delete 성공!");
        } else {
            System.out.println("delete 실패");
        }
        System.out.println("delete 종료\n");
    }

    private static Member selectOne(String memberId) throws SQLException {
        String sql = "select * from member where id = ? ORDER BY ? DESC";
        pstm = conn.prepareStatement(sql);

        pstm.setString(1, memberId);
        pstm.setString(2, "name");

        result = pstm.executeQuery();

        Member member = null;

        if (result.next()) {
            int count = 1;
            int mno         = result.getInt(count++);
            String id       = result.getString(count++);
            String password = result.getString(count++);
            String name     = result.getString(count++);
            String gender   = result.getString(count++);
            int age         = result.getInt(count++);
            String email    = result.getString(count++);
            String phone    = result.getString(count++);
            String address  = result.getString(count++);
            String hobby    = result.getString(count++);
            Date birthday   = result.getDate(count++);
            Date enrolldate = result.getTimestamp(count++);

            member = new Member(mno, id, password, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
        }

        pstm.close();
        result.close();
        return member;
    }

    private static List<Member> selectAll() throws SQLException {
        String sql = "select * from member";
        pstm = conn.prepareStatement(sql);
        result = pstm.executeQuery();

        List<Member> list = new ArrayList<>();

        while (result.next()) {
            int mno          = result.getInt("mno");
            String id        = result.getString("id");
            String password  = result.getString("password");
            String name      = result.getString("name");
            String gender    = result.getString("gender");
            int age          = result.getInt("age");
            String email     = result.getString("email");
            String phone     = result.getString("phone");
            String address   = result.getString("address");
            String hobby     = result.getString("hobby");
            Date birthday    = result.getDate("birthday");
            Date enrolldate  = result.getTimestamp("enrolldate");

            Member member = new Member(mno, id, password, name, gender, age, email, phone, address, hobby, birthday, enrolldate);
            list.add(member);
        }

        pstm.close();
        result.close();
        return list;
    }
}
