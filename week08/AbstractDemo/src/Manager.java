/**
 * 文件名：Manager.java
 * 功能描述：经理类
 */
class Manager extends Employee {
    int bonus; //奖金
    public Manager(String name,String id,double pay,int bonus) {
        super(name,id,pay);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println(this.getClass()+":");
        System.out.printf("name:%-10s\tid=%-10s\tpay=%,-15.2f\tbonus=%,-10d\n",name,id,pay,bonus);
    }
}
