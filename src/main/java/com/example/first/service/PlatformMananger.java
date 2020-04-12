package com.example.first.service;


import com.example.first.enmus.ModulEnum;
import com.example.first.service.impl.OtcServiceImpl;
import com.example.first.service.impl.PayServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hu
 * @date 2020/4/11 21:41
 */
public class PlatformMananger {

    private static final Map<String, PlatformService> dictMap = new ConcurrentHashMap<>();

    static {
        dictMap.put(ModulEnum.OTC.getModulName(), new OtcServiceImpl());
        dictMap.put(ModulEnum.PAY.getModulName(), new PayServiceImpl());
    }

    public static PlatformService getService(String curName) {
        if (StringUtils.isNoneBlank(curName)){
            return dictMap.get(curName);
        } else{
            return null;
        }
    }

}
