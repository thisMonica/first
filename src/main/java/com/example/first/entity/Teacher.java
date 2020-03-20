package com.example.first.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hu
 * @date 2020/3/20 13:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private String id;
    private String name;
    private Integer age;
    private Double salary;

}
