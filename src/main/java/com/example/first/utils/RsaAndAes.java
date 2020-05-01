package com.example.first.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author hu
 * @date 2020/4/18 23:55
 */
@Slf4j
@Component
public class RsaAndAes {


    /**
     * 加密
     *
     * @param content
     * @return
     */
    public static String encode(String content) {

        String key = UUID.randomUUID().toString();
        log.info("key:{}", key);
        String encode = AES.AESEncode(key, content);
        String sign = null;
        try {
            sign = RSA.encryptByPublicKey(key, PropertiesUtils.publicKey);
            log.info("sign:{}", sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("sign", sign);
        json.put("param", encode);
        return json.toJSONString();
    }

    /**
     * 解密
     *
     * @param pwd
     * @param content
     * @return
     */
    public static String dncode(String pwd, String content) {

        String key = null;
        try {
            key = RSA.decryptByPrivateKey(pwd, PropertiesUtils.privateKey);
            log.info("key:{}", key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String dncode = AES.AESDncode(key, content);
        return dncode;
    }


    public static void main(String[] args) {
        String content = "{\\n\" +\n" +
                "                \"\\t\\\"account_details\\\": {\\n\" +\n" +
                "                \"\\t\\t\\\"app_provider_id\\\": \\\"\" + PARTNER + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\\"app_version_id\\\": \\\"\" + appVersionId + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\\"app_end_user_id\\\": \\\"\" + appEndUserId + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\\"app_install_date\\\": \\\"\" + appInstallDate + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\\"signup_login\\\": {\\n\" +\n" +
                "                \"\\t\\t\\t\\\"ip\\\": \\\"\" + ip + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"location\\\": \\\"\" + location + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"uaid\\\": \\\"\" + uaid + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"accept_language\\\": \\\"\" + acceptLanguage + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"http_accept_language\\\": \\\"\" + httpAcceptLanguage + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"user_agent\\\": \\\"\" + userAgent + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"cookie_session_id\\\": \\\"\" + cookieSessionId + \"\\\",\\n\" +\n" +
                "                \"\\t\\t\\t\\\"timestamp\\\": \\\"\" + timestamp + \"\\\"\\n\" +\n" +
                "                \"\\t\\t}\\n\" +\n" +
                "                \"\\t},\\n\" +\n" +
                "                \"\\t\\\"transaction_details\\\": {\\n\" +\n" +
                "                \"\\t\\t\\\"payment_details\\\": {\\n\" +\n" +
                "                \"            \\\"quote_id\\\": \\\"\" + quoteId + \"\\\",\\n\" +\n" +
                "                \"            \\\"payment_id\\\": \\\"\" + paymentId + \"\\\",\\n\" +\n" +
                "                \"            \\\"order_id\\\": \\\"\" + orderId + \"\\\",\\n\" +\n" +
                "                \"            \\\"fiat_total_amount\\\": {\\n\" +\n" +
                "                \"                \\\"currency\\\": \\\"\" + fiatTotalCurrency + \"\\\",\\n\" +\n" +
                "                \"                \\\"amount\\\": \" + fiatTotalAmount + \"\\n\" +\n" +
                "                \"            },\\n\" +\n" +
                "                \"            \\\"requested_digital_amount\\\": {\\n\" +\n" +
                "                \"                \\\"currency\\\": \\\"\" + requestedDigitalCurrency + \"\\\",\\n\" +\n" +
                "                \"                \\\"amount\\\": \" + requestedDigitalAmount + \"\\n\" +\n" +
                "                \"            },\\n\" +\n" +
                "                \"            \\\"destination_wallet\\\": {\\n\" +\n" +
                "                \"                \\\"currency\\\": \\\"\" + destinationWalletCurrency + \"\\\",\\n\" +\n" +
                "                \"                \\\"address\\\": \\\"\" + destinationWalletAddress + \"\\\",\\n\" +\n" +
                "                \"                \\\"tag\\\": \\\"\" + destinationWalletTag + \"\\\"\\n\" +\n" +
                "                \"            },\\n\" +\n" +
                "                \"            \\\"original_http_ref_url\\\": \\\"\" + originalHttpRefUrl + \"\\\"\\n\" +\n" +
                "                \"        }\\n\" +\n" +
                "                \"\\t}\\n\" +\n" +
                "                \"}\"";


//        String encode = ra.encode(key, content);
//        System.out.println(encode);
//        ra.dncode()


//        System.out.println("1:" + publicKey);
//        System.out.println("2:" + privateKey);


        RsaAndAes ra = new RsaAndAes();
        String json = ra.encode(content);
        JSONObject res = JSONObject.parseObject(json);
        String sign = res.getString("sign");
        String param = res.getString("param");
        log.info("sign:{}", sign);
        log.info("param:{}", param);
        String params = ra.dncode(sign, param);
        log.info("content:{}", params);
    }


}
