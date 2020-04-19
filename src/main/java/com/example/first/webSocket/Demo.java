package com.example.first.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.example.first.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

/**
 * @author hu
 * @date 2020/3/22 0:47
 */
public class Demo {


    public static void main(String[] args) {

        List<CreditPlatform> platforms = Arrays.asList(
                new CreditPlatform("1", "Simplex"),
                new CreditPlatform("2", "uux")
        );
        Map<String, SupportedResult> map = new HashMap<>();
        List<CoinSupported> coinList = Arrays.asList(
                new CoinSupported("1", "NSG", "", "1"),
                new CoinSupported("2", "BTC", "", "2")
        );
        List<CurSupported> curList = Arrays.asList(
                new CurSupported("1", "CNY", "1"),
                new CurSupported("2", "USD", "2")
        );
        for (CreditPlatform p : platforms) {

            map.put(p.getId(), SupportedResult.builder()
                    .platform(p.getId())
                    .curSupported(curList)
                    .coinSupported(coinList)
                    .build());
        }

        System.out.println(JSONObject.toJSON(map));

    }
}
