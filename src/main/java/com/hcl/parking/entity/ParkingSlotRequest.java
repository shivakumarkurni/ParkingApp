package com.hcl.parking.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ParkingSlotRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int psRequestId;

	private int empId;

	public LocalDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}

	private LocalDate requestedDate;

	public ParkingSlotRequest() {
		
	}

	public int getPsRequestId() {
		return psRequestId;
	}

	public void setPsRequestId(int psRequestId) {
		this.psRequestId = psRequestId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "ParkingSlotRequest [psRequestId=" + psRequestId + ", empId=" + empId + "]";
	}

}
