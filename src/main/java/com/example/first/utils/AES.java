package com.example.first.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * @author hu
 * @date 2020/4/18 23:48
 */
public class AES {
    /*
     * 加密
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    public static String AESEncode(String pwd, String content) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(pwd.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            String AES_encode = parseByte2HexStr(byte_AES);
            //11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //如果有错就返加nulll
        return null;
    }

    /*
     * 解密
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    public static String AESDncode(String pwd, String content) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(pwd.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = parseHexStr2Byte(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        //如果有错就返加nulll
        return null;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    public static void main(String[] args) {
        String key = UUID.randomUUID().toString().replace("-","");
        System.out.println(key);
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
        String encode = AESEncode(key, content);
        System.out.println(encode);
//        String encryptResultStr = parseByte2HexStr(encode);
        String dncode = AESDncode(key, encode);
        System.out.println(dncode);
    }


}
