package com.hcl.parking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ParkingSlots {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int psId;
	private String status;
	private String floor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	Employee employee;

	public int getPsId() {
		return psId;
	}

	public void setPsId(int psId) {
		this.psId = psId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
