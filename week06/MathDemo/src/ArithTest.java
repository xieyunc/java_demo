public class ArithTest {
	public static void main(String[] args) {
		System.out.println("使用Arith工具类进行浮点数的算术运算：");
		System.out.println("0.05 + 0.01 = "+Arith.add(0.05,0.01));
		System.out.println("0.05 - 0.01 = "+Arith.substract(0.05,0.01));
		System.out.println("4.015 * 100 = "+Arith.multiply(4.015,100));
		System.out.println("123.5 / 100 = "+Arith.divide(123.5,100));
	}

}