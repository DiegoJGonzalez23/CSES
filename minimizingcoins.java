package DP;
import java.util.*;
import java.io.*;
public class minimizingcoins {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
	
		int acoins = Integer.parseInt(st.nextToken());
		int[] coinlist = new int[acoins];
		int wantsum = Integer.parseInt(st.nextToken());
		int[] dp = new int[wantsum];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < acoins;i++) {
			coinlist[i]  = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i  = 0; i < wantsum; i++) {
			boolean check = false;
			int min = 500000000;
			for(int coin: coinlist) {
				if(i+1==coin) {
					dp[coin-1] = 1;
					check = true;
					break;
				}
				if(i+1>coin) {
					
					min = Math.min(min, dp[i-coin]+1);
					
				}
			}
			if(!check) {
				//System.out.println(min);
			dp[i] = min;
			}
		}
		if(dp[wantsum-1] != 500000000) {
			System.out.println(dp[wantsum-1]);
		}
		else {
			System.out.println(-1);
		}
	}

}
