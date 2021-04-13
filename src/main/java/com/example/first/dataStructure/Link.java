package com.example.first.dataStructure;

import lombok.NoArgsConstructor;

/**
 * @author hu
 * @date 2021/3/20 13:12
 * @desc:实现链表
 */
public class Link {


    public class Node {
        int data;
        Node next;

        public Node() {//将头结点初始化为  data=-1   next=null
            data = -1;
            next = null;
        }

        public Node(int val) {//其他结点所需的构造函数
            data = val;
            next = null;
        }


    }
}
