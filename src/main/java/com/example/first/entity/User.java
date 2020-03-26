package com.example.first.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author hu
 * @date 2020/3/18 14:25
 */
public class User {

    private String id;
    private String name;
    private String phone;
    private String area;
    private String age;

    public User() {
    }

    public User(String id, String name, String phone, String area, String age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}



