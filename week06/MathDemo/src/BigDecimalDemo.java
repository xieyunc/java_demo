import java.math.BigDecimal;

public class BigDecimalDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = new BigDecimal(0.01);
		BigDecimal f3 = BigDecimal.valueOf(0.01);// BigDecimal.valueOf(0.01);
		
		System.out.println("使用String作为BigDecimal构造器参数：");
		System.out.println("0.05 + 0.01 = "+f1.add(f3));
		System.out.println("0.05 - 0.01 = "+f1.subtract(f3));
		System.out.println("0.05 * 0.01 = "+f1.multiply(f3));
		System.out.println("0.05 / 0.01 = "+f1.divide(f3));
		
		System.out.println("使用double作为BigDecimal构造器参数：");
		System.out.println("0.05 + 0.01 = "+f2.add(f3));
		System.out.println("0.05 - 0.01 = "+f2.subtract(f3));
		System.out.println("0.05 * 0.01 = "+f2.multiply(f3));
		System.out.println("0.05 / 0.01 = "+f2.divide(f3));
		
	}
}
