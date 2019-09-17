public class DataTypeTest01 {
	public static void main(String[] args) {
		int x,y,z;
		float f1,f2;
		double d1,d2;
		x = 10;
		y = 3;
		z = 100;
		
		f1 = 17;
		f2 = 17.0f;
		
		d1 = 10;
		d2 = 10.5;
		
		//d1 = x + 5.6; //表达式
		
		//x = x%y;
		
		//d1 = d1%y; //是正确的语句，结果为：d1 = 1.0
		
		y = x++;
		
		//y = 10, x = 11;
		
		d2 = ++d1;
		//d1 = 11, d2 = 11
		
		System.out.println("x = "+x);
		System.out.println("d1 = "+d1);
		
		System.out.println(! true && false || false);
		
		boolean bl = x>10?true:false;
		System.out.println(bl);
	}
}