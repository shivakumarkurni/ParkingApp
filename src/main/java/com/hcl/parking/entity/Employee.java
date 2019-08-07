package com.hcl.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String name;
	private String address;
	private long mobileNo;
	private String designation;
	private int joinedYear;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getJoinedYear() {
		return joinedYear;
	}

	public void setJoinedYear(int joinedYear) {
		this.joinedYear = joinedYear;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", designation=" + designation + ", joinedYear=" + joinedYear + "]";
	}

}
