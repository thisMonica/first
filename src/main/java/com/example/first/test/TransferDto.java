package com.example.first.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author hu
 * @date 2020/8/31 10:34
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferDto implements Serializable {

    private static final long serialVersionUID = 1547633407611696221L;

    //雪花算法id,业务id
    private String id;

    //扩展id
    private String tranId;

    //订单id
    private String orderId;

    //是否二维码转账（1:普通转账,3:二维码转账）
    @Builder.Default
    private Integer isQrCode = 1;

    //发送方用户id
    private String fromUserId;

    //接收方用户id
    private String toUserId;

    private String toInnerId;

    //转账类型,to pay,to wallet
    private String type;

    //转账类型
    private Integer transType;

    //交易币种
    private String coin;

    //主链名称
    private String coinCode;

    //交易数量(校验规则：小数点前后不得超过8位)
//    @PatternCheck(code = "28213", pattern = RegularCons.DOUBLE_NEGATIVE)
    private BigDecimal amount;

    //交易手续费
    private BigDecimal fee;

    //资金密码
    private String secret;

    //备注
    private String remarks;

    //交易手续费率类型：（0固定数字货币；1百分比）
    private Integer feeTransType;

    //交易手续费率值
    private BigDecimal feeRatioTrans;


    //转账消息
    private String senderName;//	否	string	-	消息发送方昵称（前端传）
    private String senderAvatar;//	否	string	-	消息发送方头像（前端传）
    private String receiverName;//	否	string	-	消息接收方昵称（前端传）
    private LocalDateTime createDate;//	否	date	-	消息创建时间 (yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd)（前端传）
    private String isRead;//	否	string	-	消息是否已读
    private String noticeType;    //否	string	-	消息类型
    private String noticeStatus;//	否	string	-	消息状态
    private String checkType;
    private String tokenLogo;
    private Integer handlerType;
    private LocalDateTime transferTime;
    private LocalDateTime confirmTime;
    private String msgContent;
    private String msgType;
    private String md5Encode;//	否	string	-	证书
    private Integer encodeType;//	否	string	-	加密类型
    private Integer tranType;//	否	string	-	交易类型 1，充值；2，提现；3，转账
    private String transactionId;//	否	string	-	交易id
    private String dealId;//	否	string	-	处理Id
    private Integer orderType;//	否	string	-	订单类型

    private String senderAsName;    //否	string	-	发送人名称（服务根据发送人接收人生成）
    private String senderAvatarThumbnail; //	否	string	-	头像缩略图

    private String receiverAsName;//	否	string	-	领取人名称
    private String receiverAvatar;//	否	string	-	领取人头像
    private String receiverAvatarThumbnail;
    //币种logo
    private String coinLogo;

    //转账图标
    private String color;

}
