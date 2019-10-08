
public class ArrayDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[][] a = new int[2][3];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		
		a[1][0] = 4;
		a[1][1] = 5;
		a[1][2] = 6;
		*/
		//int[][] a = new int[][] {{1,2,3},{4,5,6}};  
		
		int [][] a = {{1,2,3},{4,5,6}};
	
		for(int i = 0; i < a.length; i++){
			for(int j=0; j < a[i].length; j++) {
				System.out.print("a["+i+"]["+j+"]="+a[i][j]+"  ");
			}
			System.out.println("");
		}
		System.out.println("---------------------------------------------------------");
		
		int[][] d = new int[][] {{1,2,3},{4,5,6,7,8}};
		for(int i = 0; i < d.length; i++){
			for(int j=0; j < d[i].length; j++) {
				System.out.print("d["+i+"]["+j+"]="+d[i][j]+"  ");
			}
			System.out.println("");
		}
		System.out.println("---------------------------------------------------------");
		
		
	}

	
}
