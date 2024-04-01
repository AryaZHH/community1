package com.richeese.controller;

import com.richeese.entity.DiscussPost;
import com.richeese.entity.Page;
import com.richeese.entity.User;
import com.richeese.service.DiscussPostService;
import com.richeese.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/community")
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getIndePage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostCount(0));
        page.setPath("/community/index");
        List<DiscussPost> list= discussPostService.findDiscussPost(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussposts=new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String, Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.findById(post.getUserId());
                map.put("user",user);
                discussposts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussposts);
        return "/index";
    }





}
