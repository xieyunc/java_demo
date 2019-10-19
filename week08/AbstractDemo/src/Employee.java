/**
 * 文件名：Employee.java
 * 功能描述：雇员类（抽象类）
 */
abstract class Employee {
    String name; //姓名
    String id;   //工号
    double pay;  //薪水
    Employee(String name,String id,double pay)
    {
        this.name = name;
        this.id = id;
        this.pay = pay;
    }
    public abstract void work();
}
