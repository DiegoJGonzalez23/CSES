package DP;
import java.util.*;
import java.io.*;
public class CoinCombo1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		int amountofcoins = Integer.parseInt(st.nextToken());
		int desiredsum = Integer.parseInt(st.nextToken());
		int[] coinlist = new int[amountofcoins];
		long[] dp = new long[20000000]; // index is sum-1
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < amountofcoins;i++) {
			coinlist[i] = Integer.parseInt(st.nextToken());
			dp[coinlist[i]-1] =1;
		}
		
		
		
		
		for(int i = 0; i < desiredsum;i++) {
			
			for(int coin: coinlist) {
				
				if(i+1>coin) {
					dp[i] += dp[i-coin];
				}
				dp[i] = dp[i]  % 1000000007;
			}
			
		}
		pw.println(dp[desiredsum-1]);
		pw.flush();
		
	}

}
