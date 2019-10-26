/**
 * 文件名：Person.java
 */
package com.xyfd.common;

public class Person {
    private String name;
    private char sex;
    private int height;
    private int age;

    /*
     * Q：Person类文件在使用Car和Fruit时，为何无须导入Car和Fruit的包信息？
     * A：因为Person和Car、Fruit类处于同一个包下，包内部的不同类之间互相访问时无需导入包信息，
     *    故在此处无需使用import导入Car和Fruit类的包信息。
    */
    private Car car;  //车型
    private Fruit fruit; //水果


    public Person(String name,char sex,int height,int age) {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.age = age;
    }

    public void doing() {
        System.out.printf("我叫%s,%c,身高%dcm,今年%d岁！\n",name,sex,height,age);
        System.out.println("我正在开着 "+car.type+" 去买 "+fruit.name+" ……");
    }

    public void drive(String carType) {
        this.car = new Car(carType);
    }

    public void buyFruit(String fruitName) {
        fruit = new Fruit(fruitName);
    }
}
