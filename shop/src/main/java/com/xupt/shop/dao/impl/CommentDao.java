package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.comment;

import java.util.List;

public interface CommentDao {

    //新建评论
    public int addComment(comment comment);
    //展示商品评论
    public List<comment> showComment(int id);
    //删除评论
    public int deleteComment(int id);

}
