//package ProblemsSilver;
import java.util.*;
import java.io.*;
 
 
 
public class CountingRooms {
	static boolean[][] visited;
	static int[][] twodgraph;
	public static void main(String[] args) throws IOException{
		
		// Standard IO 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		
		
		// Now to setup 2d graph
		twodgraph = new int[rows][columns];
		visited = new boolean[rows][columns];
		int numberofrooms = 0;
		
		
		for(int i = 0; i < rows; i++) {
			st = new StringTokenizer(br.readLine());
			String row = st.nextToken();
			
			for(int j = 0; j < columns; j++) {
				visited[i][j] = false;
				if(row.charAt(j) == '#') {
				
					twodgraph[i][j] = 1;
				}
				
				else {
					twodgraph[i][j] = 0;
				}
 
			}
			
		}
		
		
		// end of twodgraph, now to setup the for loop
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j<columns; j++) {
				
				if(!visited[i][j] && twodgraph[i][j] == 0) {
					
					numberofrooms++;
					floodfill(i,j, rows, columns);
					
					
					
				}
				
				
			}
		}
		
		System.out.println(numberofrooms);
		
 
	}
	
	public static void floodfill(int r,int c, int rows, int columns) {
		// checking for all the bad stuff
		if(r>= rows || c>= columns || r < 0 || c < 0) {
			
		}
		
		else if(twodgraph[r][c] == 1) {
			
		}
		
		else if(visited[r][c]) {
			
		}
		else {
			
		
		visited[r][c] = true;
		floodfill(r,c+1, rows,columns);
		floodfill(r,c-1, rows,columns);
		floodfill(r+1,c, rows,columns);
		floodfill(r-1,c,rows,columns);
		}
	}
	
	
 
}
