package com.example.first.test;

<<<<<<< HEAD
import org.apache.lucene.util.RamUsageEstimator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author hu
 * @date 2020/11/12 12:13
 * @Description:
 */
public class Test2 {


    public static void main(String[] args) {
        TransferDto transferDto = new TransferDto();
        transferDto.setAmount(new BigDecimal(10));
        transferDto.setCoin("23131232131312");
        transferDto.setCoinLogo("232111111");
        transferDto.setConfirmTime(LocalDateTime.now());
        transferDto.setCreateDate(LocalDateTime.now());
        transferDto.setOrderId("21313");
        transferDto.setFromUserId("dhfshfshfk");

        //下面三个方法参数都是 Object类型

        //计算指定对象及其引用树上的所有对象的综合大小，单位字节
        long a =  RamUsageEstimator.sizeOf(transferDto);
        System.out.println(a);

        //计算指定对象本身在堆空间的大小，单位字节
        long b = RamUsageEstimator.shallowSizeOf(transferDto);
        System.out.println(b);

        //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
        String c = RamUsageEstimator.humanSizeOf(transferDto);
        System.out.println(c);

    }
=======
import org.springframework.stereotype.Service;

/**
 * @author hu
 * @date 2020/12/15 0:20
 * @desc:
 */
@Service
public interface Test2<T> {


    <T> T verify(T a);
>>>>>>> origin/master

}
