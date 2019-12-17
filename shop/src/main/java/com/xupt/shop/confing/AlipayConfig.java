package com.xupt.shop.confing;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092900621214";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCQRnPvvAu4+hShyKSHi4LjBwcLA2dhu1qj/auFoeeJgM4BOoEMZPSqJXrLl3KmY3EfBRVX7RGZ7byRLA9GEzGr9uvud//gWeFwPwetoDPDB8xS4+/fDxgMmbNrz7Kz6KwOCaaVaPyyMTFQr0jXU44M6SRqUFcQJh5wgH4Yq0ApZASQY4rdb85D84EbfLUonyPeqg8AlXzJzF2RZh2IDlsK2f0vFRq4XAa0aKx6pdKIfX91o1DYqq3zT7cpmgvup7Dkk983dM7DfA8R4ShChnlbxtUXrTInN1VUqkaRjFdwzHMau5RqBLgGPP7s81iQdbi6NpPpcVPo9FVESrFRx/mfAgMBAAECggEBAJAgIV9C7j76bDP2GQ5i+vzKn2mMG/GQ1QpvtbIIPCGrr5+gjxwPmi6CxHmvsFOxkWbYkCrG48duq+omJpftQri0MZqG+/FmOIQGIyh6mlrhZmcD1zNwg6jKvmccFDwPWhmn4Gbve0iTRd2BTXX1vTj+imc+HMtAGTZv1gfUw4LULH0K7VRVTHTSJPmIE/ZdG1P+2YTyEv2bolKKWqX3KNLnTYsI8Y13MWD+dLSmnMP2mLA9WTetH/G7BS42kf2ZIulC7MYPjID4MpZ6qWnVBXHv6J7Ww9f3zF2B4JX2cXkVXvAfE0eRnv+6QGwhgln00MRxPQXaIBEUp6sUeledmKkCgYEAxInjUILedbXNrHLoKl31VgrvJq3jxT/hl0Zb2+AAenTHJVh85kxpXhW5CHz/LqbVsiHOv3PDWlU+zjMgXheWJxhn7l5z8TnMFegwKDKH/v8GCpcTFLffvJE1x1EBblMgiBDwQfS8uYYdrd5PZpMMx9SbDnJOiEQRGd7rcnHo+xMCgYEAu+y2EBI9yeWxJFLBBvC2sYI3ZWOhjl92Cc+JQbS/ZEF4kwQ+qmZqdyGMDfpIcM+2vpYi4m8WpmHfMQobEN/Rs5S1ltZ14Jj4RYcAK+P4hYa3a339C6Tz/Fw3PCAiZlPqRVXvPHTg/PlfzMijsXENCh7zhggxnJpewfnb9he6rMUCgYBeWGLKb0gi8Vb+BVr1m4z99NnAk5DXS0cbuya1cd5I6m3+u2+Zjey2wW7FaFuHJYdHr3rz5LpOTsWLbneHM4Nc2RZrEuRNVBVoHsGfSkKGYh2gT81VEL9SYdKTD4vEThs7tgXfY4CE/qCYqjMrZkOoWaLlWHHib+pVpPEZSx0wCQKBgChbSzXkVPSYqRP92YoeA33XUwIpBTbH9VdiBD3iDQAAt14LGVIKsG5o++S8jPX9BWekYlVyOdD9T6r+WpWjGyuPkfeUkrfq4dY8iaLjUCmMprMk2US45dSaERqOZBTJjJPbQocfKnnpK9OUeuLOPligEPgFpnHVDOhnOf99VQ9pAoGAGd24aiA3IS771lOcBKDFS9PGuWziiMpG4uf6n1U93m6zCkzVZ0XH59cakh5rQ6hQ0EK53vxuduZEJTXQ8Aq5xxGqTdEuxTIoZznXIbgfBIIVNZcKv810pWFBto7yRmVrScLxgNPqnY5lmFA7C/QJ/zFRN+6t+XoUXqEFMPNNhwk=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn2nhXAxw5TcIathumBaqvBbVRiRS/Ea/syBEXonKxaO6uTgloVTMb4qRtAD+l6UZqdiJ9vKx07FB/Tes/Y0R13uI71vaOlQLLWGQDYb5k70kZ/m9X5ODj+QgerAayWj7QY5DvzkeVoTdoRZVpfa+IZJuviRaxFE3gNaOOzFKxnAQrW1pY7ErqADnx+bVZF0kmRDRtwNFVe1pV1RLF7yomxt3RePMrlLsw5gP+KjCRm1iGAgCUf+O2gNw/y0DWlHj4wjq7Ayd7++p5vr+az9OyJtMOrvApx/eGPko6Z7jq9BnS3AIIjFEX3eu2RiwxsZncULyiqrOgmt5Eds0dFVi8QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://ytsakura.free.idcfengye.com/Alipay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://ytsakura.free.idcfengye.com/Alipay/success.html";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";

	public AlipayConfig(){

    }
//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

