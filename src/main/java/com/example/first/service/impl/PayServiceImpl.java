package com.example.first.service.impl;

import com.example.first.service.PlatformService;

/**
 * @author hu
 * @date 2020/4/11 21:54
 */
public class PayServiceImpl implements PlatformService {

    @Override
    public String createTransaction(String modelName, String amount) {

        return "PAY:" + amount;
    }


}
