package com.xupt.shop.service.serviceDo;

import com.xupt.shop.service.interf.InterfUser;
import org.springframework.stereotype.Service;

@Service
public class UserDo implements InterfUser {

//    @Autowired
//    UserDao user_dao;
//    //登录的service层
//    @Override
//    public customer regesiter(String username, String password) {
//       return  user_dao.login(username,password);
//    }
//
//    @Override
//    //添加用户o的service层
//    public int addUser(String username, String password, int type) {
//        if(user_dao.find(username)!=null)
//        {
//            return 0;
//
//        }
//        return  user_dao.addUser(username,password,type);
//    }
//
//    //删除用户的service层
//    @Override
//    public int deleteUser(int id) {
//        return  user_dao.deleteUser(id);
//    }
}
