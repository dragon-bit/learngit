package com.xupt.shop.service.interf;

import com.alipay.api.AlipayApiException;

public interface InterfAlipay {

    /**
     * web端支付
     * @param outTradeNo 订单编号
     * @param totalAmount   价格
     * @param subject   名称
     */
    public String webPagePay(String outTradeNo,String totalAmount,String subject) throws Exception;


    /**
     * 交易关闭
     * @param outTradeNo 订单编号（唯一）
     */
    public String close(String outTradeNo) throws AlipayApiException;

}
