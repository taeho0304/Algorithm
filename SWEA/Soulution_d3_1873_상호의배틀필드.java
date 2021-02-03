package com.ssafy.io;

import java.io.*;
import java.util.*;

public class Soulution_d3_1873_상호의배틀필드_구미_4_배태호 {
	public static int H, W, n, x, y, nx, ny, dir;
	public static char[][] map;
	public static String cmd;
	public static int dx[] = { 0, 0, -1, 1 };
	public static int dy[] = { -1, 1, 0, 0 };
	public static BufferedReader br;
	public static char dirC[]= {'^','v','<','>'};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1873.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			init();
			for (int i = 0; i < n; i++) {		
				if (cmd.charAt(i) == 'S') shoot();
				else move(cmd.charAt(i));
			}
			sb.append("#"+(tc+1)+" ");
			for (char[] m : map) {
                for (char x : m) 
                    sb.append(x);
                sb.append("\n");
            }
		}
		System.out.println(sb);
		br.close();

	}

	private static void move(char charAt) {
		// TODO Auto-generated method stub
		
		if (charAt == 'U') {
			dir=0;
			map[y][x]=dirC[dir];
			ny=y+dy[dir];
			nx=x+dx[dir];
			if(ny<0||ny>=H||nx<0||nx>=W) return;
			if(map[ny][nx]=='.') {
				map[y][x]='.';
				y=ny;
				x=nx;
				map[ny][nx]=dirC[dir];
			}
		}else if (charAt == 'D') {
			dir=1;
			map[y][x]=dirC[dir];
			ny=y+dy[dir];
			nx=x+dx[dir];
			if(ny<0||ny>=H||nx<0||nx>=W) return;
			if(map[ny][nx]=='.') {
				map[y][x]='.';
				y=ny;
				x=nx;
				map[ny][nx]=dirC[dir];
			}
		} else if (charAt == 'L') {
			dir=2;
			map[y][x]=dirC[dir];
			ny=y+dy[dir];
			nx=x+dx[dir];
			if(ny<0||ny>=H||nx<0||nx>=W) return;
			if(map[ny][nx]=='.') {
				map[y][x]='.';
				y=ny;
				x=nx;
				map[ny][nx]=dirC[dir];
			}
		}else if (charAt == 'R') {
			dir=3;
			map[y][x]=dirC[dir];
			ny=y+dy[dir];
			nx=x+dx[dir];
			if(ny<0||ny>=H||nx<0||nx>=W) return;
			if(map[ny][nx]=='.') {
				map[y][x]='.';
				y=ny;
				x=nx;
				map[ny][nx]=dirC[dir];
			}
		}
	}

	private static void shoot() {
		// TODO Auto-generated method stub
		int sy=y+dy[dir];
		int sx=x+dx[dir]; 
		while(true) {
			if(sy<0||sy>=H||sx<0||sx>=W) break;
			if (map[sy][sx] == '#')
                break;
            if (map[sy][sx] == '*') {
                map[sy][sx] = '.';
                break;
            }
            sy+=dy[dir];
            sx+=dx[dir];
		}
	}

	public static void init() throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
					y = i;
					x = j;
					switch (map[i][j]) {
					case '^':
						dir = 0;
						break;
					case 'v':
						dir = 1;
						break;
					case '<':
						dir = 2;
						break;
					case '>':
						dir = 3;
						break;
					}
				}
			}
		}

		n = Integer.parseInt(br.readLine());
		cmd = br.readLine();
	}
}