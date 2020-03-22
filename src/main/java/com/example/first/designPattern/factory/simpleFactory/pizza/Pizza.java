package com.example.first.designPattern.factory.simpleFactory.pizza;

/**
 * @author hu
 * @date 2020/3/22 15:31
 */
//将Pizza类做成抽象的
public abstract class Pizza {

    public String name;

    //准备原材料，不同披萨不一样，因此做成一个抽象方法
    public abstract void prepare();

    //烘烤
    public void bake() {
        System.out.println(name + "baking");
    }

    //切
    public void cut() {
        System.out.println(name + "cutting");
    }

    //打包
    public void box() {
        System.out.println(name + "boxing");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
