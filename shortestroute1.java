//package s;
// Diego Gonzalez 2.23.22
import java.util.*;
import java.io.*;
public class dkstrascses {
	public static int nodes;
	public static int edges;
	public static int queries;
	public static int startnode;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(System.out);
			
				StringTokenizer st =new StringTokenizer(br.readLine());
				nodes = Integer.parseInt(st.nextToken());
				edges = Integer.parseInt(st.nextToken());
			
			

					
					
					Queue<node> pq = new PriorityQueue<>();
					ArrayList<ArrayList<node>> graph = new ArrayList<>();
					long[] distancefromstart =new long[nodes];
					for(int i = 0; i < nodes; i++){
						graph.add(new ArrayList<node>());
						distancefromstart[i]=Long.MAX_VALUE;
					}
					visited = new boolean[nodes];
				
					for(int i = 0; i < edges; i++){
						st =new StringTokenizer(br.readLine());
						int node1 = Integer.parseInt(st.nextToken());
						int node2 = Integer.parseInt(st.nextToken());
						int weight = Integer.parseInt(st.nextToken());
						graph.get(node1-1).add( new node(node2-1, weight));
						
					}
					distancefromstart[0] = 0;
					pq.add(new node(0, 0));
					while(!pq.isEmpty()){
						int current = pq.poll().destination;
						if(!visited[current]){
							visited[current] = true;
							for(node next: graph.get(current)){
								int nextdest = next.destination;
								long nextweight = next.weight;
								if(distancefromstart[current]+nextweight<distancefromstart[nextdest]){
									distancefromstart[nextdest] = distancefromstart[current]+nextweight;
									pq.add(new node(nextdest, distancefromstart[nextdest]));
								}

							}

						}

					}
				
					for(int i = 0; i < nodes; i++){
						pw.append(distancefromstart[i] + " ");
					}
						
					pw.flush();
					
					
					
					
				}
				
				

			
			
			
			static class node implements Comparable<node>{
				int destination;
				long weight;
				public node(int d, long w){
					destination = d;
					weight = w;
				}
				@Override
				public int compareTo(node o) {
					if(this.weight>o.weight){
						return 1;
					}
					else if(o.weight>this.weight){
						return -1;
					}
					return 0;
					
				}
				
				
				
				
				
			}

		

	}


