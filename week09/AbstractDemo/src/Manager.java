/**
 * 文件名：Manager.java
 * 功能描述：经理类
 */
class Manager extends Employee {
    double bonus; //奖金
    public Manager(String name,String id,double pay,double bonus) {
        super(name,id,pay);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println(this.getClass()+":");
        showInfo();
        System.out.println(String.format("我是一名经理，我的奖金是：%,.2f",bonus));
    }
}
