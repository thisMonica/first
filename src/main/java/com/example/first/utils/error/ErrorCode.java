//package com.example.first.utils.error;
//
//import javafx.application.Platform;
//
//import java.util.Locale;
//
///**
// * @author hu
// * @date 2021/7/13 1:37
// * @desc:
// */
//public class ErrorCode implements ErrorResult{
//
//    BIZ_UNKNOWN("-1",Platform.COMMON, "", "未知异常", "")
//
//    private String code;//错误码
//    private String platform;//平台
//    private String direct;//指令
//    private String msg_cn;//中文
//    private String msg_en;//英文
//
//    ErrorCode(String code, String platform, String direct, String msg_cn, String msg_en) {
//        this.code = code;
//        this.platform = platform;
//        this.direct = direct;
//        this.msg_cn = msg_cn;
//        this.msg_en = msg_en;
//    }
//    ErrorCode(String code, String platform, String direct) {
//        this.code = code;
//        this.platform = platform;
//        this.direct = direct;
//    }
//
//    @Override
//    public String code() {
//        return this.code;
//    }
//
//    @Override
//    public String message() {
//        return this.msg_cn;
//    }
//
//    @Override
//    public String platform() {
//        return this.platform;
//    }
//
//    @Override
//    public String direct() {
//        return this.direct;
//    }
//
//    @Override
//    public String message(Locale lang) {
//        if (lang.getLanguage().equals(Locale.SIMPLIFIED_CHINESE.getLanguage())) {
//            return this.msg_cn;
//        } else {
//            return this.msg_en;
//        }
//    }
//
//}
