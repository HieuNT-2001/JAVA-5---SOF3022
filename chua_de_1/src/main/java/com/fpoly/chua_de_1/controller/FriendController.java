package com.fpoly.chua_de_1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.chua_de_1.model.Friend;
import com.fpoly.chua_de_1.service.FriendService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    // Hiển thị danh sách bạn bè
    @GetMapping
    public String listFriends(Model model) {
        List<Friend> friends = friendService.getAllFriends();
        System.out.println(friends);
        model.addAttribute("friends", friends);
        model.addAttribute("title", "Friend list");
        model.addAttribute("content", "friends/list");
        return "layout/base";
    }

    // Hiển thị form thêm bạn bè
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("friend", new Friend());
        model.addAttribute("title", "Create Friend");
        model.addAttribute("content", "friends/create");
        return "layout/base";
    }

    // Thêm bạn bè
    @PostMapping("/create")
    public String createFriend(@ModelAttribute("friend") Friend friend, Model model) {
        friendService.createFriend(friend);
        return "redirect:/friends";
    }

    // Hiển thị form sửa bạn bè
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Friend friend = friendService.getFriendById(id);
        model.addAttribute("friend", friend);
        model.addAttribute("title", "Edit Friend");
        model.addAttribute("content", "friends/edit");
        return "layout/base";
    }

    // Cập nhật bạn bè
    @PostMapping("/update")
    public String updateFriend(@ModelAttribute("friend") Friend friend, Model model) {
        friendService.updateFriend(friend);
        return "redirect:/friends";
    }

    // Xóa bạn bè
    @GetMapping("delete/{id}")
    public String deleteFriend(@PathVariable("id") int id) {
        friendService.deleteFriend(id);
        return "redirect:/friends";
    }

}
