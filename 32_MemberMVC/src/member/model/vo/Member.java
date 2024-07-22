package member.model.vo;

import java.util.Date;

public class Member {
	private int 	mno;
	private String 	id;
	private String 	password;
	private String 	name;
	private String 	gender;
	private int 	age;
	private String 	email;
	private String 	phone;
	private String 	address;
	private String 	hobby;
	private Date 	birthday;
	private Date 	enrolldate;

	public Member() {
		super();
	}

	public Member(int mno, String id, String password, String name, String gender, int age, String email, String phone,
			String address, String hobby, Date birthday, Date enrolldate) {
		super();
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

	@Override
	public String toString() {
		return "Member [mno=" + mno + ", id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + ", hobby=" + hobby
				+ ", birthday=" + birthday + ", enrolldate=" + enrolldate + "]";
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

}
