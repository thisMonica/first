package com.example.first.utils;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author hu
 * @date 2020/4/17 2:00
 */
public class RSA {
    //非对称密钥算法
    private static final String KEY_ALGORITHM = "RSA";
    //密钥长度，在512到65536位之间，建议不要太长，否则速度很慢，生成的加密数据很长
    private static final int KEY_SIZE = 512;
    //字符编码
    private static final String CHARSET = "UTF-8";

    private static String content = "{\\n\" +\n" +
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


    static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJNTXsqa/CsgLiOA8WZc6RY4QTZc1pEFxlRkM49pk0klDfE0ex9t8eUHH4fmeln4UbHJfnopBYrwqb3v7X8jHkECAwEAAQ==";

    static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAk1Neypr8KyAuI4DxZlzpFjhBNlzWkQXGVGQzj2mTSSUN8TR7H23x5Qcfh+Z6WfhRscl+eikFivCpve/tfyMeQQIDAQABAkBUUuizoIfrCy09ZwVEqLNE44f33KV3Nk3xabTVRgFmYG7Beio0UvyMQEXwIVeEYFVwSoz6n1qoCwfLy9aEPqzRAiEA1fe/KniGo3n83q2pfl0b7TRoADSesdIag9PDvcPgqR0CIQCwREAT+HT8u2pUZUS0lwt06ZfBGroZCLUsI9fwzrjkdQIgSvoepc5IN77Gam1mSF5uK8fCbdgCiAM8wVcSb0vVTM0CIQCXCHQLaJn9MC1k0Tz0rHPRopI4kUkiSDbM8o2GNetxPQIhAM7xh/Jg5aOJF5bTLtCtwL5blruQqO7j5SbnsMIyDjVL";


    /**
     * 生成密钥对
     *
     * @return KeyPair 密钥对
     */
    public static KeyPair getKeyPair() throws Exception {
        return getKeyPair(null);
    }

    /**
     * 生成密钥对
     *
     * @param password 生成密钥对的密码
     * @return
     * @throws Exception
     */
    public static KeyPair getKeyPair(String password) throws Exception {
        //实例化密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器
        if (password == null) {
            keyPairGenerator.initialize(KEY_SIZE);
        } else {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes(CHARSET));
            keyPairGenerator.initialize(KEY_SIZE, secureRandom);
        }
        //生成密钥对
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 取得私钥
     *
     * @param keyPair 密钥对
     * @return byte[] 私钥
     */
    public static byte[] getPrivateKeyBytes(KeyPair keyPair) {
        return keyPair.getPrivate().getEncoded();
    }

    /**
     * 取得Base64编码的私钥
     *
     * @param keyPair 密钥对
     * @return String Base64编码的私钥
     */
    public static String getPrivateKey(KeyPair keyPair) {
        return Base64.getEncoder().encodeToString(getPrivateKeyBytes(keyPair));
    }

    /**
     * 取得公钥
     *
     * @param keyPair 密钥对
     * @return byte[] 公钥
     */
    public static byte[] getPublicKeyBytes(KeyPair keyPair) {
        return keyPair.getPublic().getEncoded();
    }

    /**
     * 取得Base64编码的公钥
     *
     * @param keyPair 密钥对
     * @return String Base64编码的公钥
     */
    public static String getPublicKey(KeyPair keyPair) {
        return Base64.getEncoder().encodeToString(getPublicKeyBytes(keyPair));
    }

    /**
     * 私钥加密
     *
     * @param data       待加密数据
     * @param privateKey 私钥字节数组
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成私钥
        PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        //数据加密
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * 私钥加密
     *
     * @param data       待加密数据
     * @param privateKey Base64编码的私钥
     * @return String Base64编码的加密数据
     */
    public static String encryptByPrivateKey(String data, String privateKey) throws Exception {
        byte[] key = Base64.getDecoder().decode(privateKey);
        return Base64.getEncoder().encodeToString(encryptByPrivateKey(data.getBytes(CHARSET), key));
    }

    /**
     * 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥字节数组
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成公钥
        PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
        //数据加密
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey Base64编码的公钥
     * @return String Base64编码的加密数据
     */
    public static String encryptByPublicKey(String data, String publicKey) throws Exception {
        byte[] key = Base64.getDecoder().decode(publicKey);
        return Base64.getEncoder().encodeToString(encryptByPublicKey(data.getBytes(CHARSET), key));
    }

    /**
     * 私钥解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥字节数组
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成私钥
        PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        //数据解密
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data       Base64编码的待解密数据
     * @param privateKey Base64编码的私钥
     * @return String 解密数据
     */
    public static String decryptByPrivateKey(String data, String privateKey) throws Exception {
        byte[] key = Base64.getDecoder().decode(privateKey);
        return new String(decryptByPrivateKey(Base64.getDecoder().decode(data), key), CHARSET);
    }

    /**
     * 公钥解密
     *
     * @param data      待解密数据
     * @param publicKey 公钥字节数组
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //产生公钥
        PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
        //数据解密
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data      Base64编码的待解密数据
     * @param publicKey Base64编码的公钥
     * @return String 解密数据
     */
    public static String decryptByPublicKey(String data, String publicKey) throws Exception {
        byte[] key = Base64.getDecoder().decode(publicKey);
        return new String(decryptByPublicKey(Base64.getDecoder().decode(data), key), CHARSET);
    }

    /**
     * 测试加解密方法
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        //生成密钥对，一般生成之后可以放到配置文件中
//        KeyPair keyPair = RSA.getKeyPair();
//        //公钥
//        String publicKey1 = RSA.getPublicKey(keyPair);
//        //私钥
//        String privateKey1 = RSA.getPrivateKey(keyPair);

        System.out.println("公钥：\n" + publicKey);
        System.out.println("私钥：\n" + privateKey);
        content = "RSA 加解密测试!";
//        {
//            System.out.println("\n===========私钥加密，公钥解密==============");
//            String s1 = RSA.encryptByPrivateKey(content, privateKey);
//            System.out.println("加密后的数据:" + s1);
//            String s2 = RSA.decryptByPublicKey(s1, publicKey);
//            System.out.println("解密后的数据:" + s2 + "\n\n");
//        }

        {
            System.out.println("\n===========公钥加密，私钥解密==============");
            String s1 = RSA.encryptByPublicKey(content, publicKey);
            System.out.println("加密后的数据:" + s1);
            String s2 = RSA.decryptByPrivateKey(s1, privateKey);
            System.out.println("解密后的数据:" + s2 + "\n\n");
        }

    }
}
