package com.example.first.utils.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;

/**
 * @author hu
 * @date 2020/8/17 16:47
 */
@Slf4j
public final class RSAUtils {
    private static final String KEY_ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;//设置长度
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    public static final String RSA_TYPE = "RSA/ECB/PKCS1Padding";

    private final static String PUBLIC_KEY_NAME = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1++H290V1BRamxsvnDyhDohHEtZ1l++ZDcEyNk5jgRMpyEHa6N+X3tx7g5MSSw/cXB7Mirltq23e897gP7klKbjvxIf7uYOHjZNLfhZEcn7qo0VuA+80rBCWh79jvUOHdJtIvOA9zRS3k/ZQAbSiJghSbyrKgWsKuIvHau8zYnfTgcIjgqXebBRh+Ox1Y0yq3HHIFKFk1jhDZ+Y16chrhMjrQBVzlO4ccWas8K1mNLJ3qy/mmJ+pbxcAUIiH9o881X+qERwMzhLJe4Bs3+xLbKIwMAWez6zPa+o0B8BDvpdMAYdnp0w5JWAy5xBZmqjALl0b0dmlYxvTLbPrsmBnVwIDAQAB";
    private final static String PRIVATE_KEY_NAME = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDX74fb3RXUFFqbGy+cPKEOiEcS1nWX75kNwTI2TmOBEynIQdro35fe3HuDkxJLD9xcHsyKuW2rbd7z3uA/uSUpuO/Eh/u5g4eNk0t+FkRyfuqjRW4D7zSsEJaHv2O9Q4d0m0i84D3NFLeT9lABtKImCFJvKsqBawq4i8dq7zNid9OBwiOCpd5sFGH47HVjTKrcccgUoWTWOENn5jXpyGuEyOtAFXOU7hxxZqzwrWY0snerL+aYn6lvFwBQiIf2jzzVf6oRHAzOEsl7gGzf7EtsojAwBZ7PrM9r6jQHwEO+l0wBh2enTDklYDLnEFmaqMAuXRvR2aVjG9Mts+uyYGdXAgMBAAECggEAfFGQUzmmzpHlVDVDpNyXEQnOeX709sNfx7Z51SAuU2qX/I5FnRrVkd44UhkDSCnagULOGfQFutOnr5maW7WZOrsZd3meqECccxrhNLdXMt/08IkRfLxkA8gNEhxTLOzK+IxKRUuI6SBLTKlbiI/ZZrIV26C0M+xPoM4AwoTyfXZWNOKKHBrF/wd2usnqbPELAbLi87C51XqCsTeD4iFuB3kYMGroq6vTH+Hbn7k2OURWOxG2lMtc4m+66XDZzecGbvF8HCyWb+kpcOm1sEboyg0KpI+xxZ/+rHlOa0BQvvPW73ds8HKkKG6DKGQxuuWRetswikJmiR1OqlvkorUxaQKBgQD4Kk0Kh5lL2CDbUpHrXpfnazZnochGtGrcsgsLDTij2ZjqdN+dZ8ldjsG2Ge+vgou2Rm+Ra/lEPyg0U3nEkUaqkyyxzGgcytFkSK7Opqpw8l7E3maNn5Cr4WmFmkrZbkWcRfb1OZzDyc60viXqR572BTrRF5vGB+Hc5iDV/aZNfQKBgQDewL8sws9iyx2umPFAAo1X/DpAubYlGUV8ScIVRImlNYDJPFxmt6ILExvdm9X/QATt8nJq6OIQSF/gv8IJzBGT4YEpLRECHj+WkJI3VMeHTVeEoQywJEkUbY0/ZyaIzZrEXsPd5RheaSdkzi+iCKyMpybQkdMZsG6RDu/7uP0wYwKBgD632h6mJH0Bk1Q6qvw0POnUs7w/K/GKmVNLf/T8E2t9i+L9RKJwX3jQom5WYbgWox6e8IVtJ2MzHwMScbzXBmgHqA0LXuif7YmNwPgjMQI4jvDsUDjMsfBumI+WbgJDlz4mhIJ3XAIzV5VgVQ6/qRH+Ql4jvE+xIEkGtBfA8i21AoGBAIqKxRyY2ZWvkPl75GiUbcaweKazGsd+LUp9MXo604Vufngq06mLQvyyWN1/RBzqe2ZnKaS2zYulCAToH04qnzAjzEqI3hA8Mf56UoaZczQC9ZDm/dY76zwKWxR5Gm1xu3WxHw9OotZtfnPjDZsw2+jrOWf1mp9arZoI+VfNmaPTAoGBAOkDqR2NUSmOM1N1XRowcTos5DBlFBEXgcc8jYGhD8e1cLGcR+1c+FiEQDusWWaLbe4wcYXo5yEsrADBzkdjtO5jVJF86qqZNxxmCz4iOHjQVX3Ek/j7By3MJscl3Oq0dGa3Y10Xi6KtxnQSl+8+2uVl9UhRMl6kM3gdlcEIj3b8";
    private final static String SERVICE_PUBLIC_KEY_NAME = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApXrOQ8d9wUvSDLqeS+QbrL6FMg5qKeB9PDnUkvXG71xUUSxTW4uIDggzm3v9OXTYRt3yZEvr2WNJuvLy6xtBn/sMbP9vVnp1Q6KcXCH8pWnHjziS/Wv2cwjYWMVEOj0vICtiwei7G9oulgzBRnO8k8kIeqxrDLwHC9w2/Zh6R39f49xqIo2iHIiVSGObNEqS9NkGbKVPR1WlVzB2VKGc4tsciWYagi98OZwMuvz29Ums0yiG06HlUSAhAWEb+qKeoT4e3/DtXRbu8fXEF4EzjR0X4O6sS3PdwKpKkIlih99IdbnJ0jL8ALqhgV6NXEe/az4+I5WHM7lzviLVWfxIIQIDAQAB";

    /**
     * 生成公、私钥
     * 根据需要返回String或byte[]类型
     *
     * @return
     */
    public static JSONObject createRSAKeys() {
        JSONObject jsonObject = new JSONObject();
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            //获取公、私钥值
            String publicKeyValue = Base64.encodeBase64String(publicKey.getEncoded());
            String privateKeyValue = Base64.encodeBase64String(privateKey.getEncoded());

            //存入
            jsonObject.put("publicKey", publicKeyValue);
            jsonObject.put("privateKey", privateKeyValue);

            log.info(" >>> ", publicKeyValue);
            log.info(" >>> ", privateKeyValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    //获取本地RSA公钥
    public static PublicKey getPublicKey() {
        try {
            return getPublicKey(PUBLIC_KEY_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取本地RSA公钥
    public static String getPublicKeyString() {
        try {
            return PUBLIC_KEY_NAME;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取服务器RSA公钥
    public static PublicKey getServicePublicKey() {
        try {
            return getPublicKey(SERVICE_PUBLIC_KEY_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取RSA公钥 根据钥匙字段
    public static PublicKey getPublicKey(String key) {
        try {
            byte[] byteKey = Base64.decodeBase64(key);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byteKey);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return keyFactory.generatePublic(x509EncodedKeySpec);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取RSA私钥   根据钥匙字段
    private static PrivateKey getPrivateKey(String key) {
        try {
            byte[] byteKey = Base64.decodeBase64(key);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(byteKey);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //本地RSA私钥 签名
    public static String sign(String requestData) {
        String signature = null;
        byte[] signed = null;
        try {
            PrivateKey privateKey = getPrivateKey(PRIVATE_KEY_NAME);
            Signature Sign = Signature.getInstance(SIGNATURE_ALGORITHM);
            Sign.initSign(privateKey);
            Sign.update(requestData.getBytes());
            signed = Sign.sign();
            signature = Base64.encodeBase64String(signed);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }

    //公钥验证签名   base64签名 signature   签名内容requestData
    public static boolean verifySign(String requestData, String signature) {
        boolean verifySignSuccess = false;
        try {
            PublicKey publicKey = getServicePublicKey();
            Signature verifySign = Signature.getInstance(SIGNATURE_ALGORITHM);
            verifySign.initVerify(publicKey);
            verifySign.update(requestData.getBytes());

            verifySignSuccess = verifySign.verify(Base64.decodeBase64(signature));
            System.out.println(" >>> " + verifySignSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return verifySignSuccess;
    }

    public static String encrypt(String clearText) {
        String encryptedBase64 = "";
        try {
            Key key = getServicePublicKey();
            final Cipher cipher = Cipher.getInstance(RSA_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //
            byte[] encryptedBytes = cipher.doFinal(clearText.getBytes("UTF-8"));
            encryptedBase64 = Base64.encodeBase64String(encryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedBase64;
    }

    public static String decrypt(String encryptedBase64) {
        String decryptedString = "";
        try {
            Key key = getPrivateKey(PRIVATE_KEY_NAME);
            final Cipher cipher = Cipher.getInstance(RSA_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedBytes = Base64.decodeBase64(encryptedBase64);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            decryptedString = new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedString;
    }

    public static void main(String[] args) {
        String sign = sign("123");
        boolean v = verifySign("123", sign);
        System.out.println(v);

    }


}
