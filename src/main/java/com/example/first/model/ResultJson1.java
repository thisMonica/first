//package com.example.first.model;
//
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author hu
// * @date 2020/3/18 18:03
// */
//@Data
//public class ResultJson1<T> implements Serializable {
//
//    private static final long serialVersionUID =-123847128341023033L;
//
//    @JSONField
//    private boolean success = true;
//    @JSONField
//    private String message = null;
//    @JSONField
//    private String errorCode = "0";
//    @JSONField
//    private String errorMsg = "操作成功";
//    @JSONField
//    private Integer total = 0;
//    @JSONField
//    private List<T> data = new ArrayList();
//
//    public ResultJson1() {
//    }
//
//    /**
//     * 当有异常时，直接throw一个实现ErrorCode的异常类
//     * 通过global异常处理器，就可以把ResultJson封装起来，这样代码简洁优美
//     * 如果没有BaseException可以注释掉这个方法
//     */
////    public ResultJson(BaseException exception) {
////        if (exception != null) {
////            success = false;
////            errorCode = exception.getErrorCode();
////            errorMsg = exception.getErrorMsg();
////        }
////    }
//    /**
//     *  虽然很多人都写为isSuccess(),但强烈不建议，因为相当于getSuccess()
//     *  可以用idea的自动生成下，如果有isSuccess()，就不会生成getSuccess()
//     */
//    public boolean successFlag() {
//        return success;
//    }
//
//    public ResultJson1(List<T> data) {
//        if (data != null && data.size() > 0) {
//            this.data = data;
//        }
//    }
//
//    public ResultJson1(T data) {
//        if (data != null) {
//            this.data.add(data);
//        }
//    }
//    //  失败情况的构造  只用errorCode，errorMsg即可
//    public ResultJson1(String errorCode, String errorMsg) {
//        this.success=false;
//        this.errorCode=errorCode;
//        this.errorMsg=errorMsg;
//    }
//}
