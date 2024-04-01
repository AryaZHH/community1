package com.richeese.service;

import com.richeese.dao.DiscussPostMapper;
import com.richeese.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    public List<DiscussPost> findDiscussPost(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPost(userId,offset,limit);
    }

    public int findDiscussPostCount(int userId){
        return discussPostMapper.selectDiscussPostCount(userId);
    }
}
