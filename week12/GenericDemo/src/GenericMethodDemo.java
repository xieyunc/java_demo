/**
 * 文件名：GenericMethodDemo.java
 * 功能描述：泛型方法测试Demo
 */
public class GenericMethodDemo {

    //定义一个泛型方法 printArray
    public static <T> void printArray(T[] inputArray) {
        //输出数组元素
        for(T element: inputArray) {
            System.out.printf("%s ",element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //创建不同类型数组：Integer, Double, Character
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4};
        Character[] charArray = {'H','E','L','L','O'};

        System.out.println("整形数组元素为：");
        printArray(intArray);//传递一个整形数组

        System.out.println("双精确度型数组元素为：");
        printArray(doubleArray);

        System.out.println("字符型数组元素为：");
        printArray(charArray);

    }
}
