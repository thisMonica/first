package com.example.first.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

/**
 * @author hu
 * @date 2020/3/18 14:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User> {

    private String id;
    private String name;
    private String phone;
    private String area;
    private String age;


    @Override
    public int compareTo(@NotNull User o) {
        return 0;
    }
}



