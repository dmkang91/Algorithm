package Q.NO;

import java.util.Scanner;
import java.io.FileInputStream;

public class No1022 {
	public static void main(String args[]) throws Exception{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("text/no1022.txt"));
		
		Whirlpool table = new Whirlpool();
		//table.proc(r1, c1, r2, c2);
		
		sc.close();	
	}
}
class Whirlpool{
	
	Whirlpool(){
	}
	
	int[][] proc(int r1, int c1, int r2, int c2){	// row, column 
		int [][]result;
		int width, height;
		int max = 0, value = 1;
		
		width = c2 - c1 + 1;
		height = r2 - r1 + 1;
		
		if(Math.abs(r1) > Math.abs(r2)){ max = Math.abs(r1); }
		if(max < Math.abs(c1)){ max = Math.abs(c1); }
		if(max < Math.abs(c2)){ max = Math.abs(c2); }
		
		result = new int[max * 2 + 1][max * 2 + 1];	// 정사각형 배열 생성
		
		for(int i = 0; i < max * 2 + 1; i ++){
			
		}
		
		return result;
		
	}
}