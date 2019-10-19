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
            属性：姓名，工号，薪水
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
        Manager m = new Manager("张三丰", "1001", 12000.00, 6000);
        m.work();

        Programmer p = new Programmer("小宇飞刀", "2001", 9500.00);
        p.work();
    }
}
