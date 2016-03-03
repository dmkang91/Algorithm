package Q.NO;

import java.util.Scanner;

public class No1149 {
	public static void main(String []args){
		int houseCnt;
		int cost[][];	// RGB ¼ø
		int totalCost = 0;
		
		Scanner sc = new Scanner(System.in);
		
		houseCnt = sc.nextInt();
		cost = new int[houseCnt][3];
		
		cost[0][0] = sc.nextInt();
		cost[0][1] = sc.nextInt();
		cost[0][2] = sc.nextInt();
		
		for(int i = 1; i < houseCnt; i ++){
			int R, G, B;
			R = sc.nextInt();
			G = sc.nextInt();
			B = sc.nextInt();
			
			cost[i][0] = R + Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] = G + Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] = B + Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		totalCost = cost[houseCnt-1][0];
		if(totalCost > cost[houseCnt-1][1]){ totalCost = cost[houseCnt-1][1]; }
		if(totalCost > cost[houseCnt-1][2]){ totalCost = cost[houseCnt-1][2]; }
		System.out.println(totalCost);

	}
}
