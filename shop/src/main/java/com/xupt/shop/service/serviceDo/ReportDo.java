package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Report;
import com.xupt.shop.service.interf.InterfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportDo implements InterfReport {
    @Autowired
    ReportDo reportDao;

    // 添加举报
    @Override
    public int addReport(int user_id, String info) {return reportDao.addReport(user_id, info);};
    // 删除举报
    @Override
    public int deleteReport(int id) {return reportDao.deleteReport(id);};
    // 查询所有举报
    @Override
    public List<Report> findAllReport() {return reportDao.findAllReport();};

}