package com.multi.ex06.collections;

import java.util.Objects;

// Comparable : 정렬을 지원하는 Interface
// Cloneable : 객체를 Hard copy하기 위해 선언하는 인터페이스
public class Member4 implements Comparable<Member4>, Cloneable {
	private String id;
	private String name;
	private int age;
	private double account; // 계좌 잔액

	public Member4() {
		super();
	}

	public Member4(String id, String name, int age, double account) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", account=" + account + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(account, age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member4 other = (Member4) obj;
		return Double.doubleToLongBits(account) == Double.doubleToLongBits(other.account) && age == other.age
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	// 객체 비교시 정렬 기준을 정하는 메소드
	@Override
	public int compareTo(Member4 o) {
		// ID 기준으로 오름차순 정렬해보기
		return id.compareTo(o.getId()); // compareTo : 작으면 -1, 같으면 0, 크면 +1
		// ID 기준으로 내림차순 정렬해보기
//		return o.getId().compareTo(id); // compareTo : 작으면 -1, 같으면 0, 크면 +1
	}
	
	// clone 생성하는 방법1
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}

	// clone 생성하는 방법2 - 이렇게 써라!
	@Override
	protected Member4 clone() {
		try {
			return (Member4) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}









