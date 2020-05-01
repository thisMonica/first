package com.example.first.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hu
 * @date 2020/5/2 0:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    private static final long serialVersionUID = 7326279769485332650L;
    private String deptId;
    private String deptNo;
    private String deptName;
    private String userId;

}
