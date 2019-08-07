package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.ParkingSlots;

@Repository
public interface ParkingSlotsRepository extends JpaRepository<ParkingSlots, Integer> {
	
	@Query(name="select * from parking_slots ps where ps.emp_id=:userId",nativeQuery=true)
	public ParkingSlots getParkingSlotsByEmployee(@Param("userId") int userId);

}
