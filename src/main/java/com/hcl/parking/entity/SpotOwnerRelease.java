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
public class SpotOwnerRelease {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int soReleaseId;
	private int days;
	private int userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "psId")
	ParkingSlots parkingSlots;

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

	@Override
	public String toString() {
		return "SpotOwnerRelease [soReleaseId=" + soReleaseId + ", days=" + days + ", userId=" + userId
				+ ", parkingSlots=" + parkingSlots + "]";
	}

}
