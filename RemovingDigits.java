package DP;
import java.util.*;
import java.io.*;
public class RemovingDigits {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int[] dp = new int[num+1];
		dp[0]= 0;
		
		
		for(int i = 1; i < num+1; i++) {
				
				int min = Integer.MAX_VALUE;
				int temp = i;
				if(i<10) {
					dp[i] = 1;
				}
				else {
					while(temp>=10) {
						int last = temp % 10;
						temp/=10;
						if(last !=0) {
						min = Math.min(min, dp[i-last]+1);
						}
						
					}
					
				
				int last = temp % 10;
				min = Math.min(min, dp[i-last]+1);
				
				dp[i] = min;
				}
		}
		
		System.out.println(dp[num]);
		
		
		
	}

}
