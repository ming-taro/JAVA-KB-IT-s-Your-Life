package com.multi.ex02.preparedstatement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//VO : Table의 컬럼 값을 멤버 변수로 가진 객체
//	   Table과 Mapping하여 설계할때는 가급적 Table과 네이밍을 일치하는 것이 일반적인데,
//     컬럼명이 길 경우 Java 스타일로 변경하고 다른 방법으로 Mapping이 필요하다.
//     단, 대소문자는 구별되지 않음으로 무관함.
public class Member {
    private int     mno; // INT PRIMARY KEY auto_increment,
    private String  id; // VARCHAR(20) NOT NULL unique,
    private String  password; // VARCHAR(20) NOT NULL,
    private String  name; // VARCHAR(20) NOT NULL,
    private String  gender; // VARCHAR(1) CHECK(GENDER IN ('M','F')),
    private int     age; //     INT NOT NULL,
    private String  email; // VARCHAR(30),
    private String  phone; // CHAR(13),
    private String  address; // 	VARCHAR(200),
    private String  hobby; // VARCHAR(100),
    private Date    birthday; // DATE, // java date는 날짜와 시간 둘다 담을수 있음
    private Date    enrolldate; // DATETIME DEFAULT NOW()
    
    // LocalDate : 날짜만, LocalDateTime : 시간 날짜 동시
    // 주의 : 레거시에서는 Date로 바꿔서 사용 할 것
//    private LocalDate birthday; // DATE,
//    private LocalDateTime enrolldate; // DATETIME DEFAULT NOW()


    public Member() {
    }

    public Member(int mno, String id, String password, String name, String gender, int age, String email, String phone, String address, String hobby, Date birthday, Date enrolldate) {
        this.mno = mno;
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.hobby = hobby;
        this.birthday = birthday;
        this.enrolldate = enrolldate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("mno=").append(mno);
        sb.append(", id='").append(id).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", hobby='").append(hobby).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", enrolldate=").append(enrolldate);
        sb.append('}');
        return sb.toString();
    }
}
