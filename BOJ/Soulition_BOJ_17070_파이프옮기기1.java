package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Soulition_BOJ_17070_파이프옮기기1 {
	/*
	 * 유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의
	 * 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 각각의 칸은 빈
	 * 칸이거나 벽이다.
	 * 
	 * 파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.
	 * 
	 * 파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다. 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안
	 * 된다. 즉, 파이프는 항상 빈 칸만 차지해야 한다.
	 * 
	 * 파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수
	 * 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
	 * 
	 * 파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가
	 * 있다.
	 * 
	 * 아래 그림은 파이프가 놓여진 방향에 따라서 이동할 수 있는 방법을 모두 나타낸 것이고, 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.
	 * * 가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의
	 * 개수를 구해보자.
	 */
	static int N, cnt;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 1, 1);

		System.out.println(cnt);
	}

	private static void dfs(int y, int x, int dir) {
		// TODO Auto-generated method stub
		if (y == N - 1 && x == N - 1) {
			cnt++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (dir == 1 && i == 0) continue;
			if (dir == 0 && i == 1) continue;

			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N)continue;
			if (i==2 && (map[ny][nx-1]==1 || map[ny-1][nx]==1)) continue;
			if (map[ny][nx] == 1)continue;
			dfs(ny, nx, i);
		}
	}

}