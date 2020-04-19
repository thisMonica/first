package com.example.first.utils;

/**
 * @author hu
 * @date 2020/4/17 2:18
 */

import java.security.SecureRandom;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

/**
 * DES加密介绍
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 * 。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
public class DES {
    public DES() {

    }

    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = "{\\n\" +\n" +
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
        //密码，长度要是8的倍数
        String password = "12345678";

        byte[] result = DES.encrypt(str.getBytes(), password);
        System.out.println("加密后：" + new String(result));
        //直接将如上内容解密
        try {
            byte[] decryResult = DES.decrypt(result, password);
            System.out.println("解密后：" + new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 加密
     *
     * @param datasource byte[]
     * @param password   String
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param src      byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}
