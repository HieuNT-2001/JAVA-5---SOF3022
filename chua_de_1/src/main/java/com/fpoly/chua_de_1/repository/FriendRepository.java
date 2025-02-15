package com.fpoly.chua_de_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.chua_de_1.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

}
