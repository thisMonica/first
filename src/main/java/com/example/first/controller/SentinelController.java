package com.example.first.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hu
 * @date 2020/10/28 23:22
 * @desc:
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {


    @GetMapping("/test")
    public String test() {

        try (Entry entry = SphU.entry("HelloWorld")) {
            // Your business logic here.
            return "hello world";
        } catch (BlockException e) {
            // Handle rejected request.
            e.printStackTrace();
            return "系统繁忙!";
        }


    }


    @PostConstruct//当前类的构造函数执行之后执行
    public void flowRule() {

        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        // set limit qps to 20
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

    }


}
