package com.xupt.shop.service.serviceDo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.xupt.shop.confing.AlipayConfig;
import com.xupt.shop.service.interf.InterfAlipay;
import org.springframework.stereotype.Service;

@Service
public class AlipayDo implements InterfAlipay{


    private DefaultAlipayClient alipayClient=new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

    @Override
    public String webPagePay(String outTradeNo, String totalAmount, String subject) throws Exception {
        AlipayTradePagePayRequest alipayRequest =new AlipayTradePagePayRequest();
        //同步通知，支付完成后，支付成功页面
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        //异步通知，支付完成后，需要进行的异步处理
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\","
                + "\"total_amount\":\""+ totalAmount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\"商品名称\","
                + "\"timeout_express\":\"90m\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String result = alipayClient.pageExecute(alipayRequest).getBody().replace('\"','\'').replace('\n',' ');
        return result;
    }


    @Override
    public String close(String outTradeNo) throws AlipayApiException {
        AlipayTradeCloseRequest alipayRequest = new AlipayTradeCloseRequest();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ outTradeNo +"\"," +"\"trade_no\":\""+ "" +"\"}");

        String result = alipayClient.execute(alipayRequest).getBody();

        return result;
    }

}
