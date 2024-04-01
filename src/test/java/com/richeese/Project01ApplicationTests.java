package com.richeese;

import com.richeese.dao.DiscussPostMapper;
import com.richeese.dao.UserMapper;
import com.richeese.entity.DiscussPost;
import com.richeese.entity.User;
import com.richeese.service.DiscussPostService;
import com.richeese.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ContextConfiguration(classes = Project01Application.class)
class Project01ApplicationTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        List<DiscussPost> list= discussPostService.findDiscussPost(0,0,10);
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

    }

}
