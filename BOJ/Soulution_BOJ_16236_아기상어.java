package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_16236_아기상어 {
	static int n, m, size, answer, y, x, cnt;
	static int[][] map, copy;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Pos_16236> fish;
	static StringTokenizer st;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		size = 2;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					y = i;
					x = j;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
//			System.out.println(1);
			fish = new ArrayList<>();
			Queue<Pos_16236> q = new LinkedList<Pos_16236>();
			visited = new boolean[n][n];

			visited[y][x] = true;
			q.add(new Pos_16236(y, x, 0));
			int found = -1;
			
			while (!q.isEmpty()) {
				Pos_16236 cq = q.poll();
				int cy = cq.y;
				int cx = cq.x;
				int cdis = cq.dis;

				if (cdis == found)
					break;

				for (int i = 0; i < 4; i++) {
					int ny = cy + dy[i];
					int nx = cx + dx[i];

					if (isInside(ny, nx) && !visited[ny][nx]) {
						if( map[ny][nx]<=size) {
							visited[ny][nx]=true;
							if(map[ny][nx]>0 && map[ny][nx]<size) {
								found=cdis+1;
								fish.add(new Pos_16236(ny, nx, cdis+1));
							}
							q.offer(new Pos_16236(ny, nx, cdis+1));
						}
					}
				}
			}

			if (found == -1) break;
			if (fish.size() > 1)
				Collections.sort(fish, new Comparator<Pos_16236>() {
					@Override
					public int compare(Pos_16236 o1, Pos_16236 o2) {
						int diff = Integer.compare(o1.dis, o2.dis);

						if (diff != 0)
							return diff;
						else {
							diff = Integer.compare(o1.y, o2.y);
							return diff != 0 ? diff : Integer.compare(o1.x, o2.x);
						}
					}
				});
			
			Pos_16236 cp=fish.get(0);
			answer += cp.dis;
            map[y][x] = 0;
            y = cp.y;
            x = cp.x;
            if (size == ++cnt) {
                size++;
                cnt = 0;
            }
//            System.out.println(y+" "+x);
		}
		System.out.println(answer);
	}

	private static boolean isInside(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < n && nx < n)
			return true;
		return false;
	}

}

class Pos_16236 {
	int y, x, dis;

	public Pos_16236(int y, int x, int dis) {
		super();
		this.y = y;
		this.x = x;
		this.dis = dis;
	}
}