package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Report;

import java.util.List;

public interface ReportDao {
    // 添加举报
    int addReport(int user_id, String info);
    // 删除举报
    int deleteReport(int id);
    // 查询所有举报
    List<Report> findAllReport();

}
