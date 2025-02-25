package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    // JpaRepository cung cấp sẵn các phương thức như save, findAll, findById, delete, v.v.
}
