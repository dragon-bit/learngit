package com.xupt.shop.service.interf;

import com.xupt.shop.bean.Comment;

import java.util.List;

public interface InterfComment {
    //新建评论
    public int addComment(Comment comment);
    //展示商品评论
    public List showComment(int id);
    //删除评论
    public int deleteComment(int id);
}
