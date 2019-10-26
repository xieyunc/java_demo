/**
 * 文件名：TestDemo.java
 */
package com.xyfd.test; //TestDemo类所在的包，与Car、Fruit、Person处于不同的包。

import com.xyfd.common.Person; //导入要引用的类，如果要导入包下的所有类可写为：com.xyfd.common.*;

public class TestDemo {
    public static void main(String[] args) {
        Person myMaster = new Person("小宇飞刀",'男',170,27);

        myMaster.drive("玛莎拉蒂");
        myMaster.buyFruit("橘子");

        myMaster.doing();

    }
}
