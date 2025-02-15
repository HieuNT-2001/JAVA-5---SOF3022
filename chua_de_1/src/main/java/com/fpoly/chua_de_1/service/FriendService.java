package com.fpoly.chua_de_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpoly.chua_de_1.model.Friend;
import com.fpoly.chua_de_1.repository.FriendRepository;

@Service
public class FriendService {

    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    public Friend createFriend(Friend Friend) {
        return friendRepository.save(Friend);
    }

    public Friend getFriendById(int id) {
        Optional<Friend> optional = friendRepository.findById(id);
        return optional.orElse(null);
    }

    public Friend updateFriend(Friend Friend) {
        return friendRepository.save(Friend);
    }

    public void deleteFriend(int id) {
        friendRepository.deleteById(id);
    }
}
