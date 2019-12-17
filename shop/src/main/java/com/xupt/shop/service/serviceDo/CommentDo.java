package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Comment;
import com.xupt.shop.dao.impl.CommentDao;
import com.xupt.shop.service.interf.InterfComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentDo implements InterfComment {
    @Resource
    CommentDao commentDao;
//添加申请
    @Override
    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }
//查看商品评论
    @Override
    public List showComment(int id) {
        return commentDao.showComment(id);
    }
//删除评论
    @Override
    public int deleteComment(int id) {
        return commentDao.deleteComment(id);
    }
}
