public class Demo5 {
	public static void main(String[] arg) {
		for(int row=1;row<=5;row++){//外层循环，控制行数
			for(int col=1;col<=row;col++){//内层循环，控制列数
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}