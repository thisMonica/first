//package com.example.first.test;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author hu
// * @date 2020/8/21 11:29
// */
//public class SignDemo {
//
//
//    /**
//     * @param paramMap  参数集合
//     * @param secretKey 签名key
//     * @return 返回签名新key
//     * @description 对html5的签名验证
//     */
//    public static String signOfH5(Map<String, String> paramMap, String secretKey) {
//
//        StringBuilder content = new StringBuilder();
//        try {
//            String encodeKey = DigestUtils.md5Hex(DigestUtils.sha256Hex(secretKey).toLowerCase()).toLowerCase();
//            // 按照key做排序
//            List<String> keys = new ArrayList<String>(paramMap.keySet());
//            Collections.sort(keys);
//            for (int i = 0; i < keys.size(); i++) {
//                String key = keys.get(i);
//                if ("sign".equals(key) || "key".equals(key)) {
//                    continue;
//                }
//                String value = paramMap.get(key);
//                if (StringUtils.isNotBlank(value)) {
//                    content.append(key).append("=").append(value).append("&");
//                }
//            }
//            content.append("key=").append(encodeKey);
////            logger.info(content.toString());
//            System.out.println("------contexnt-----" + content.toString());
//            String sign = DigestUtils.md5Hex(content.toString()).toLowerCase();
////            logger.info(sign);
//            return sign;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//
//
//}
