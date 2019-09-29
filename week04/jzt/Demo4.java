public class Demo4 {
	public static void main(String[] arg) {
		for(int row=1;row<=5;row++){//外层循环，控制行数
			for(int x=1;x<=5-row;x++){//控制每行前面输出的空格数
				System.out.print("  ");
			}
			for(int col=1;col<=2*row-1;col++){//内层循环，控制列数
				System.out.print("★");
			}
			System.out.println("");//每行的内容打印完成后，换行
		}
	}
}