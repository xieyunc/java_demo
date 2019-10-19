/**
 * 文件名：Programmer.java
 * 功能描述：程序员类
 */
class Programmer extends Employee{
    int bonus; //奖金
    public Programmer(String name,String id,double pay) {
        super(name,id,pay);
    }

    public void work() {
        System.out.println(this.getClass()+":");
        System.out.printf("name:%-10s\tid=%-10s\tpay=%,-15.2f\n",name,id,pay);
    }

}
