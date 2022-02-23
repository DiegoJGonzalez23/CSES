//package algorithms;
import java.util.*;
import java.io.*;
import java.lang.Math;
 // Diego Gonzalez
public class Labyrinth {
	public static int startx;
	public static int starty;
	public static node[][] last;
 
	public static int endx;
	public static int endy;
	public static Queue q;
	public static char[][] lastt;
	public static String s;
	public static int[][] graph;
	public static boolean[][] visited;
	public static int[][] distancefromstart;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		graph = new int[height][width];
		distancefromstart = new int[height][width];
		visited = new boolean[height][width];
		lastt = new char[height][width];
		last = new node[height][width];
		q = new LinkedList<Integer>();
		
		 startx = 0;
		 starty = 0;
		 endx = 0;
		 endy = 0;
		
		for(int i = 0; i<height;i++) {
			st = new StringTokenizer(br.readLine());
			String row = st.nextToken();
			for(int j = 0; j < row.length();j++) {
				distancefromstart[i][j]=Integer.MAX_VALUE;
				
				if(row.charAt(j) == '#') {
					graph[i][j]=0;
				}
				if(row.charAt(j) == '.') {
					graph[i][j]=1;
				}
				if(row.charAt(j) == 'A') {
					distancefromstart[i][j] = 0;
					graph[i][j]=2;
					startx=i;
					starty=j;
					
					
					
				}
				if(row.charAt(j) == 'B') {
					graph[i][j]=3;
					endx = i;
					endy=j;
					
				}
				
			}
			
		}
		q.add(new node(startx,starty));
		distancefromstart[startx][starty] = 0;
		visited[startx][starty] = true;
		StringBuilder sb = new StringBuilder("");
		floodfill(startx,starty,height,width);
		
		
		if(distancefromstart[endx][endy] != Integer.MAX_VALUE) {
			System.out.println("YES");
			System.out.println(distancefromstart[endx][endy]);
			int x =  endx;
			int y = endy;
			while(x!= startx || y!=starty) {
				sb.append(lastt[x][y]);
				int tempx=x;
				x = last[x][y].x;
				y=last[tempx][y].y;
				
						
			}
			for(int p = sb.length()-1;p>=0; p--) {
				pw.append(sb.charAt(p));
			}
			
			
			pw.flush();
		
			
		}
		else {
			System.out.println("NO");
		}
			
			
 
}
	
	public static int floodfill(int r, int c, int rows, int columns) {
 
		while(!q.isEmpty()) {
		node current = (node) q.peek();
		q.poll();
		node[] arr = new node[4];
		arr[0] = new node(current.x+1,current.y);
		arr[1] = new node(current.x-1,current.y);
		arr[2] = new node(current.x,current.y+1);
		arr[3] = new node(current.x,current.y-1);
		for(node next: arr) {
 
		if(next.x>= rows || next.y >= columns || next.x < 0 || next.y < 0) {
			
		}
		
		else if(graph[next.x][next.y]==0) {
			
		}
		
		else if(visited[next.x][next.y]) {
			
		}
		
		else {
			
			distancefromstart[next.x][next.y] = distancefromstart[current.x][current.y]+1;
			
			last[next.x][next.y] = current;
			if(next.x>current.x && next.y==current.y) {
				lastt[next.x][next.y] = 'D';
					
			}
			else if(next.x<current.x && next.y==current.y) {
				lastt[next.x][next.y] = 'U';
					
			}
			else if(next.x==current.x && next.y>current.y) {
				lastt[next.x][next.y] = 'R';
					
			}
			else if(next.x==current.x && next.y<current.y) {
				lastt[next.x][next.y] = 'L';
					
			}
			 if(next.x==endx && next.y==endy) {
				return 1;
			}
	
			visited[next.x][next.y] = true;
			q.add(next);
				
 
			
 
		}
 
		}
		
		}
		return 0;
		
	}
	static class node{
		int x;
		int y;
		public node(int xx, int yy) {
			x=xx;
			y=yy;
		}
 
	}
 
}
