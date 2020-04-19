package com.example.first.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author hu
 * @date 2020/4/14 16:10
 */
@Data
@Builder
@AllArgsConstructor
public class CurSupported {

    private String id;

    private String curName;

    private String sort;




}
