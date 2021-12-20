package programmers;

import java.util.*;

public class Soulition_programmers_level3_가장먼노드 {
	private static Queue<Integer> q = new LinkedList<>();
	private static boolean[][] map;
	private static boolean[] visited;
	private static int answer = 0;
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		////////////////////////////////////////////////////////
		visited = new boolean[n];
	    map = new boolean[n][n];
	    
	    for(int i=0; i<edge.length; i++){
	    	map[edge[i][0]-1][edge[i][1]-1]=true;
	    	map[edge[i][1]-1][edge[i][0]-1]=true;
	    }
	    
	    visited[0]=true;
	    q.add(0);

	    bfs(n);

		System.out.println(answer);
	}

	private static void bfs(int n) {
		while(!q.isEmpty()){
	        int qSize = q.size();
	        for(int i=0; i<qSize;i++){
	            int node = q.poll();
	            for(int j=0; j<n; j++)
	                if(map[j][node]&&!visited[j]){
	                	visited[j]=true;
	                    q.add(j);
	                }
	        }
	        answer=qSize;
	    }
	}
}
