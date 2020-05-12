package com.example.first.demo;

/**
 * @author hujiahan
 * @date 2020/1/31 17:43
 */
public final class Type {

    private Byte a = 127;
    Long b = 123L;
    Double c = 0.9123239d;
    float d = 0.91239234f;

    public Type() {
        System.out.println("无参构造方法");
    }

    public Type(Byte a, Long b, Double c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        System.out.println("有参构造方法");
    }

    public void say(String words) {
        System.out.println("输出say语句:" + words);
    }

    public static void main(String[] args) {
//        String s1 = "uml";
//        String s2 = "uml";
//        String s3 = new String("uml");
//        String s4 = new String("uml");
        String s = "祝你考出好成绩！asds";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s3 == s4);
//        System.out.println(s3.equals(s4));
//        System.out.println(s1 == s4);
        System.out.println(s.length());

//        System.out.println("is " + 100 + 5);
//        System.out.println(100 + 5 + "is ");
//        System.out.println("is " + (100 + 5));
//        System.out.println(5+~10);


    }
}
