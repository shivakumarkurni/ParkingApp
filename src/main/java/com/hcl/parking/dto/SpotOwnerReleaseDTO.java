package com.hcl.parking.dto;

import java.io.Serializable;
import java.util.Date;

import com.hcl.parking.entity.ParkingSlots;

public class SpotOwnerReleaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int soReleaseId;
	private int days;
	private int userId;

	ParkingSlots parkingSlots;
	private Date availableTillDate;

	public int getSoReleaseId() {
		return soReleaseId;
	}

	public void setSoReleaseId(int soReleaseId) {
		this.soReleaseId = soReleaseId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ParkingSlots getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(ParkingSlots parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	
	public Date getAvailableTillDate() {
		return availableTillDate;
	}

	public void setAvailableTillDate(Date availableTillDate) {
		this.availableTillDate = availableTillDate;
	}

	@Override
	public String toString() {
		return "SpotOwnerRelease [soReleaseId=" + soReleaseId + ", days=" + days + ", userId=" + userId
				+ ", parkingSlots=" + parkingSlots + "]";
	}

}
