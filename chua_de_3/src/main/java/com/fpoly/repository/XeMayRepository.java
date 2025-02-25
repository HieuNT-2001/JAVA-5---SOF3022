package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.model.XeMay;

@Repository
public interface XeMayRepository extends JpaRepository<XeMay, Integer> {

}
