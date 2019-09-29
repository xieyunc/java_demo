public class JztDemo {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 7; i++) {//控制行数
			
			for(int j=1;j <= 7-i; j++) {//控制要输出的★前的空位置数，一个★占两个空格位
				System.out.print("  ");
			}
			for (int j = 1; j <= 2*i-1; j++) {//控制每行要输出的★数量
				System.out.print("★");
			}
			System.out.println();//换行
		}
	}	
}