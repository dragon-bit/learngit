package com.xupt.shop.demo;

import com.xupt.shop.bean.People;
import com.xupt.shop.service.serviceDo.PeopleDo;
import com.xupt.shop.service.serviceDo.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleServlet {
    @Autowired
    PeopleDo peopleDo;
    @RequestMapping("/updatePeopleById")
    public int  updatePeopleById(String username,String address){
        int id=1;
        People people=new People();
        people.setAddress(address);
        people.setUsername(username);
        people.setId(id);
        return peopleDo.updatePeople(people);
    }
    @RequestMapping("/findPeopleById")
    public People findPeopleById(){
        int id=1;
       return peopleDo.findPeopleById(id);
    }
}
