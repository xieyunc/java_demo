/*
某公司雇员示例：
需求：
        程序员　：姓名，工号，薪水，工作内容
        项目经理：姓名，工号，薪水，工作内容，还有奖金
        对给出需求进行数据建模
分析：

        在这个问题领域中，先找出涉及的对象。

        通过名词进行提炼：
        程序员：
            属性：姓名，工号，薪水，开发语言
            行为：工作
        项目经理：
            属性：姓名，工号，薪水，奖金
            行为：工作

        程序员和经理不存在直接继承关系
        但是程序员和经理却具有共性内容
        因此可设计一个共同的抽象类（雇员类Employee），由它派生并实现程序员类（Programmer）和经理类（Manager）
*/
/**
 * 文件名：AbstractTest.java
 * 功能描述：对Employee/Manager/Programmer进行测试
 */
public class AbstractTest {
    public static void main(String[] args) {
        Manager m = new Manager("张三丰子", "1001", 12000.00, 6000.00);
        m.work();

        Employee em = m;//声明了一个Employee的变量并赋值，它是Manager和Programmer的父类
        //因为Employee中并无bonus成员，故必须对em进行类型判断，只有类型转换后才能访问bonus成员
        if(em instanceof Manager) {
            ((Manager) em).bonus = 3500;
        }
        em.work();

        em = new Programmer("小宇飞刀", "2001", 9500.00,"Java");
        em.work();

    }
}
