package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soulution_swea_professional_5643_키순서 {
    static int N, M, adj[][], radj[][];
    static int cnt;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj = new int[N + 1][N + 1];
            radj = new int[N + 1][N + 1];
            
            int i, j;
            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
 
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
 
                radj[j][i] = adj[i][j] = 1;
            }
 
            int res = 0;
            for (int k = 1; k <= N; k++) {
                cnt = 0;
                dfs(k, adj, new boolean[N + 1]);
                dfs(k, radj, new boolean[N + 1]);
                if (cnt == N - 1) res++;
            }
            System.out.println("#" + tc + " " + res);
        }
 
    }
 

    private static void dfs(int n, int[][] adj, boolean[] visited) {
        visited[n] = true;
 
        for (int i = 1; i <= N; i++) 
            if (adj[n][i] == 1 && !visited[i]) {
                cnt++;
                dfs(i, adj, visited);
            }
    }
}

