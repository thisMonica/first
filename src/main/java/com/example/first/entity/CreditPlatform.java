package com.example.first.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author hu
 * @date 2020/4/14 23:59
 */
@Data
@Builder
@AllArgsConstructor
public class CreditPlatform {

    private String id;

    private String name;
}
