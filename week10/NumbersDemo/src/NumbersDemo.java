/**
 * 文件名：NumbersDemo.java
 * 功能描述：Numbers和Math类操作Demo
 */
public class NumbersDemo {
    public static void main(String[] args) {

        double dVer = 11.5;
        float fVer = -11.5f;

        System.out.printf("dVer=%.2f,fVer=%.2f\n",dVer,fVer);

        System.out.printf("Math.ceil(%.2f)=%.2f,",dVer,Math.ceil(dVer));
        System.out.printf("Math.ceil(%.2f)=%.2f\n",fVer,Math.ceil(fVer));

        System.out.printf("Math.floor(%.2f)=%.2f,",dVer,Math.floor(dVer));
        System.out.printf("Math.floor(%.2f)=%.2f\n",fVer,Math.floor(fVer));

        // round() 表示"四舍五入"，算法为Math.floor(x+0.5) ，即将原来的数字加上 0.5 后再向下取整，
        // 所以 Math.round(11.5) 的结果为 12，Math.round(-11.5) 的结果为 -11。
        System.out.printf("Math.round(%.2f)=%d,",dVer,Math.round(dVer));
        System.out.printf("Math.round(%.2f)=%d\n",fVer,Math.round(fVer));

        System.out.printf("Math.rint(%.2f)=%.2f,",dVer,Math.rint(dVer));
        System.out.printf("Math.rint(%.2f)=%.2f\n",fVer,Math.rint(fVer));

        dVer = Double.parseDouble("11.5");  //parseDouble() 返回一个基本数据类型
        Double dObj = Double.valueOf("11.5");  //valueOf()  返回一个基本数据类型的类对象

        System.out.println("dVer="+dVer+",dObj="+dObj.toString());

        int iVer = (int)Double.parseDouble("11.5");
        Integer iObj = Double.valueOf("-11.5").intValue();
        System.out.println("iVer="+iVer+",iObj="+iObj.toString());

        System.out.println("dObj.compareTo(dVer):"+dObj.compareTo(dVer));
        System.out.println("dObj.equals(dVer):"+dObj.equals(dVer));

        System.out.println("Math.pow(3,2):"+Math.pow(3,2));

        System.out.println("输出5个1~100之间的随机数:");
        for (int i = 0; i < 5; i++) {
            System.out.print((Math.round(Math.random()*100))+"  ");
        }
    }
}
