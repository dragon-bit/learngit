package com.xupt.shop.demo;

import com.xupt.shop.service.serviceDo.ReportDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportServlet {
    @Autowired
    ReportDo reportDo;
    @RequestMapping("addResport")
    public String addResport(int user_id, String info)
    {
        if(reportDo.addReport(user_id,info)>=0){
            return "添加成功";
        }
        return "添加失败";
    }
    @RequestMapping("deleteResport")
    public String deleteResport(int id)
    {
        if(reportDo.deleteReport(id)>=0){
            return "删除成功";
        }
        return "删除失败";
    }
    @RequestMapping("findAllResport")
    public List findAllResport()
    {
     return reportDo.findAllReport();
    }

}
