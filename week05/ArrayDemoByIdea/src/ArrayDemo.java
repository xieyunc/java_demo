public class ArrayDemo {
    public static void main(String[] args) {
        int[] a; //声明了一个数组变量a
        a = new int[5];//开启了5个元素的数组对象及空间
        //int[] a = new int[5]; //合二为一

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        for(int i=0; i < a.length ;i++) {
            System.out.print("a[" + i + "]=" + a[i] + "  ");
        }
        System.out.println("\n----------------------------------------");

        int[] b = {1,2,3,4,5,6,7,8}; //定义一个静态数组 int[] b = new int[] {1,2,3,4,5,6,7,8};
        for(int i=0; i < b.length ;i++) {
            System.out.print("b[" + i + "]=" + b[i] + "  ");
        }
        System.out.println("\n----------------------------------------");

        for (int x:b) {//for... each
            System.out.print("x="+x+" ");
        }
        System.out.println("\n----------------------------------------");

    }
}
