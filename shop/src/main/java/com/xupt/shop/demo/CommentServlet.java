package com.xupt.shop.demo;

import com.xupt.shop.Cache;
import com.xupt.shop.MySessionContext;
import com.xupt.shop.bean.Comment;
import com.xupt.shop.bean.User;
import com.xupt.shop.service.serviceDo.CommentDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class CommentServlet {
    @Autowired
    CommentDo commentDo;

    @RequestMapping("/addComment")
    public String addComment(int id,String context)
    {
//       MySessionContext mySessionContext = new MySessionContext();
//       Cache cache = (Cache) mySessionContext.get("1");
//        User user = (User) cache.getValue();
        Comment comment=new Comment();
//        comment.setUser_id(user.getId());
        comment.setUser_id(3);
        comment.setCommodity_id(id);
        comment.setContent(context);
        if(commentDo.addComment(comment)!=0)
            return "评论成功";
        else
            return  "评论失败";
    }

    @RequestMapping("/showComment")
    public List showComment(int id)
    {
        List list=commentDo.showComment(id);
        return list;
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(int id)
    {
        if(commentDo.deleteComment(id)>=0)
            return "删除成功";
        else
            return "删除失败";
    }
}
