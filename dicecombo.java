//package ss;
import java.util.*;
 
 
public class heatw {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		long[] ways = new long[1000005];
		
		ways[0] = 1;
		ways[1] = 2;
		ways[2] = 4;
		ways[3] = 8;
		ways[4] = 16;
		ways[5] = 32;
		long totalsix = 63;
		
		
		if(s<= 6){System.out.println(ways[s-1]);}
		
		else{
			
			for(int p = 6; p < s; p++){
				
				ways[p] = (ways[p-1] + ways[p-2] + ways[p-3] + ways[p-4] + ways[p-5] + ways[p-6]) % 1000000007;
				
				
				
				
				
			}
			
			
			System.out.println(ways[s-1] % 1000000007);
		}
		
		
		
		
		
		
	}
}
