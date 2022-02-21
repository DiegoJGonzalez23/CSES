package algorithms;

import java.util.*;
import java.io.*;
// BFS PROBLEMS

public class MessageRoute  {
	
	public static Queue pq = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n =  Integer.parseInt(st.nextToken());
		int conns = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		boolean[] visited= new boolean[n];
		int[] distance = new int[n];
		
		
		for(int i = 0;i <n;i++) {
			graph.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < conns;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x-1).add(y-1);
			graph.get(y-1).add(x-1);	
		}
		
		visited[0] = true;
		distance[0] = 1;
		int[] last = new int[n];
		pq.add(0);
		
		while(!pq.isEmpty()) {
			
			int current = (int) pq.peek();
			pq.poll();
			
			for(int next: graph.get(current)) {
				if(!visited[next]) {
					
					visited[next] = true;
					distance[next] = distance[current] +1;
					last[next] = current;
					pq.add(next);
					
					
				}
			}
			
		}
		
		if(distance[n-1] == Integer.MAX_VALUE) {
			
			System.out.println("IMPOSSIBLE");
		}
		else {
		System.out.println(distance[n-1]);
		ArrayList<Integer> finall = new ArrayList<>();
		finall.add(n-1);
		int x = last[n-1];
		while(x != 0) {
			finall.add(x);
			 x = last[x];
		}
		
		System.out.print(1 + " ");
		for(int i = finall.size()-1; i >=0; i--){
			System.out.print((finall.get(i)+1) +" ");
		}
		
		
		
		
		
		
		
		
	}
	}
	
	
	
	
	
	
	
	
	
	
}
