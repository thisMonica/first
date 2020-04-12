package com.example.first.controller;

import com.example.first.model.ResultJson;
import com.example.first.service.PlatformMananger;
import com.example.first.service.PlatformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author hu
 * @date 2020/4/11 22:04
 */
@RestController
@RequestMapping("/card")
@Slf4j
public class CardController {


    @PostMapping("/create")
    public ResultJson<Object> create(String modul, String amount) {
        log.info("请求参数:{},{}", modul, amount);
        PlatformService service = PlatformMananger.getService(modul);
        String res = service.createTransaction(modul, amount);
        return ResultJson.toSuccess(res);
    }


}
