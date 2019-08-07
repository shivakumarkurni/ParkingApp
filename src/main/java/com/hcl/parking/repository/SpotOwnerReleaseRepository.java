package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.SpotOwnerRelease;

@Repository
public interface SpotOwnerReleaseRepository extends JpaRepository<SpotOwnerRelease, Integer> {

}
