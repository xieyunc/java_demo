/**
 * 文件名：Programmer.java
 * 功能描述：程序员类
 */
class Programmer extends Employee{
    String developmentLanguage; //开发语言
    public Programmer(String name,String id,double pay,String developmentLanguage) {
        super(name,id,pay);
        this.developmentLanguage = developmentLanguage;
    }

    public void work() {
        System.out.println(this.getClass()+":");
        showInfo();
        System.out.println(String.format("我是一名程序员，我的开发语言是：%s",developmentLanguage));
    }

}
