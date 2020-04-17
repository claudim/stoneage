package com.univaq.stoneage.repository;

import com.univaq.stoneage.Model.MMarker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarkerRepository extends JpaRepository<MMarker, String> {
}
