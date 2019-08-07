package com.hcl.parking.dto;

import java.io.Serializable;

public class ParkingSlotsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int psId;
	private String status;
	private String floor;

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

}
