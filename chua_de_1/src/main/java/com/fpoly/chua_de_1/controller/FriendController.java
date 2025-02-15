package com.fpoly.chua_de_1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.chua_de_1.model.Friend;
import com.fpoly.chua_de_1.service.FriendService;

@Controller
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping
    public String listFriends(Model model) {
        List<Friend> friends = friendService.getAllFriends();
        System.out.println(friends);
        model.addAttribute("friends", friends);
        model.addAttribute("title", "Friend list");
        model.addAttribute("content", "friends/list");
        return "layout/base";
    }
}
