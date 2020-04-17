package com.univaq.stoneage.repository;

import com.univaq.stoneage.Model.MSquare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISquareRepository extends JpaRepository<MSquare, String> {
}
