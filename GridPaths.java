//package DP;
import java.util.*;
import java.io.*;


public class GridPaths  {
	public static int[][] dp;
	public static int[][] grid;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int len = Integer.parseInt(st.nextToken());
		grid = new int[len][len];
		dp = new int[len][len];
		dp[0][0] = 1;
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j = 0; j < len;j++) {
				if(s.charAt(j)=='*') {
					grid[i][j] = 1;	
					
				}
				else {
					grid[i][j] = 0;	
				}
		}
			

	}
		//traverse(0,0,len);
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len;j++) {
				
				if(grid[0][0]==1) {
					break;
				}
				
				
				if(grid[i][j]==0) {
				if(i-1>= 0 && i-1 < len && j >= 0 && j < len) {
					
					dp[i][j] += dp[i-1][j];
					dp[i][j] %= 1000000007;
					
					
				}
				if(i>= 0 && i < len && j-1 >= 0 && j-1 < len) {
					
					dp[i][j] += dp[i][j-1];
					dp[i][j] %= 1000000007;
					
					
				}
				}
		}

	}
		if(grid[0][0]==1) {
			System.out.println(0);
		}
		else {
		System.out.println(dp[len-1][len-1]);
		}
		

}
	
}
