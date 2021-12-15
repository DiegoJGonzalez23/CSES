package ProblemsSilver;
import java.util.*;

import java.io.*;
 
 
 
public class buildingroads{
	public static int countt = 0;
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int cities = Integer.parseInt(st.nextToken())-1;
	int roads = Integer.parseInt(st.nextToken());
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	boolean[] visited = new boolean[cities+1];
	ArrayList<Integer> fathers = new ArrayList<>();
	
	for(int i = 0; i <= cities; i++) {graph.add(new ArrayList<Integer>());}
	
	for(int i = 0; i <= cities; i++) {visited[i] = false;}
	
	
	for(int i = 0; i< roads; i++) {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		graph.get(x).add(y);
		graph.get(y).add(x);
		
	}
	
	int nextpapi = findnextunvisited(visited);
	
	while(nextpapi!= -1) {
		
		fathers.add(nextpapi);
		dfs(graph, visited, nextpapi);
		nextpapi = findnextunvisited(visited);
	}
	System.out.println(fathers.size()-1);
	for(int i = 0; i < fathers.size()-1; i++) {
		System.out.println((fathers.get(i)+1) + " " + (fathers.get(i+1)+1));
	}
	
	
	
	}
	static int pastcount = 0;
	public static int findnextunvisited(boolean[] visit) {
		int count = 0;
		for(int i = pastcount; i < visit.length; i++) {
			if(!visit[i]) {
				pastcount+= count;
				return pastcount;
			}
			
			count++;
		
		}
		
		return -1;
		
		
	}
 
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startnode) {
		visited[startnode] = true;
		
		for(Integer next:graph.get(startnode)) {
			if(!visited[next]) {
				dfs(graph, visited, next);
			}
		}
		
	}
}
 