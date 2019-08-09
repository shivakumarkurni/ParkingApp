package com.hcl.parking.dto;

import java.time.LocalDate;

public class ParkingSlotRequestDTO {

	private int psRequestId;

	private int empId;

	private LocalDate requestedDate;

	public LocalDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}

	public ParkingSlotRequestDTO(int psRequestId, int empId) {
		super();
		this.psRequestId = psRequestId;
		this.empId = empId;
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
