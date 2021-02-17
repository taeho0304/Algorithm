package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_16935_배열돌리기3 {
	/*크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.

	1번 연산은 배열을 상하 반전시키는 연산이다.

	1 6 2 9 8 4 → 4 2 9 3 1 8
	7 2 6 9 8 2 → 9 2 3 6 1 5
	1 8 3 4 2 9 → 7 4 6 2 3 1
	7 4 6 2 3 1 → 1 8 3 4 2 9
	9 2 3 6 1 5 → 7 2 6 9 8 2
	4 2 9 3 1 8 → 1 6 2 9 8 4
	   <배열>       <연산 결과>
	2번 연산은 배열을 좌우 반전시키는 연산이다.

	1 6 2 9 8 4 → 4 8 9 2 6 1
	7 2 6 9 8 2 → 2 8 9 6 2 7
	1 8 3 4 2 9 → 9 2 4 3 8 1
	7 4 6 2 3 1 → 1 3 2 6 4 7
	9 2 3 6 1 5 → 5 1 6 3 2 9
	4 2 9 3 1 8 → 8 1 3 9 2 4
	   <배열>       <연산 결과>
	3번 연산은 오른쪽으로 90도 회전시키는 연산이다.

	1 6 2 9 8 4 → 4 9 7 1 7 1
	7 2 6 9 8 2 → 2 2 4 8 2 6
	1 8 3 4 2 9 → 9 3 6 3 6 2
	7 4 6 2 3 1 → 3 6 2 4 9 9
	9 2 3 6 1 5 → 1 1 3 2 8 8
	4 2 9 3 1 8 → 8 5 1 9 2 4
	   <배열>       <연산 결과>
	4번 연산은 왼쪽으로 90도 회전시키는 연산이다.

	1 6 2 9 8 4 → 4 2 9 1 5 8
	7 2 6 9 8 2 → 8 8 2 3 1 1
	1 8 3 4 2 9 → 9 9 4 2 6 3
	7 4 6 2 3 1 → 2 6 3 6 3 9
	9 2 3 6 1 5 → 6 2 8 4 2 2
	4 2 9 3 1 8 → 1 7 1 7 9 4
	   <배열>       <연산 결과>
	5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 
	아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.

	1 1 1 1 2 2 2 2
	1 1 1 1 2 2 2 2
	1 1 1 1 2 2 2 2
	4 4 4 4 3 3 3 3
	4 4 4 4 3 3 3 3
	4 4 4 4 3 3 3 3
	5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 
	4번을 1번으로 이동시키는 연산이다.

	3 2 6 3 1 2 9 7 → 2 1 3 8 3 2 6 3
	9 7 8 2 1 4 5 3 → 1 3 2 8 9 7 8 2
	5 9 2 1 9 6 1 8 → 4 5 1 9 5 9 2 1
	2 1 3 8 6 3 9 2 → 6 3 9 2 1 2 9 7
	1 3 2 8 7 9 2 1 → 7 9 2 1 1 4 5 3
	4 5 1 9 8 2 1 3 → 8 2 1 3 9 6 1 8
	     <배열>            <연산 결과>
	6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.

	3 2 6 3 1 2 9 7 → 1 2 9 7 6 3 9 2
	9 7 8 2 1 4 5 3 → 1 4 5 3 7 9 2 1
	5 9 2 1 9 6 1 8 → 9 6 1 8 8 2 1 3
	2 1 3 8 6 3 9 2 → 3 2 6 3 2 1 3 8
	1 3 2 8 7 9 2 1 → 9 7 8 2 1 3 2 8
	4 5 1 9 8 2 1 3 → 5 9 2 1 4 5 1 9
	     <배열>            <연산 결과>
	입력
	첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.

	둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

	마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 
	문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.

	출력
	입력으로 주어진 배열에 R개의 연산을 순서대로 수행한 결과를 출력한다.*/
	
	static int n, m, r;
	static StringTokenizer num;
	static int map[][] = new int[100][100];
	static int tmp[][] = new int[100][100];
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		for (int tc = 0; tc < r; tc++) 
			trans(Integer.parseInt(st.nextToken()));
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}

	private static void trans(int num) {
		int tmpNum;
		switch (num) {
		case 1:
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++)
					tmp[i][j]=map[n-1-i][j];
			
			copy();
			break;

		case 2:
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++)
					tmp[i][j]=map[i][m-1-j];
			copy();
			break;
		case 3:
			int h=n-1;
			tmpNum=n;
			n=m;
			m=tmpNum;
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++)
					tmp[i][j]=map[h-j][i];
			copy();
			break;
		case 4:
			int w=m-1;
			tmpNum=n;
			n=m;
			m=tmpNum;
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < m; ++j)
					tmp[i][j] = map[j][w-i];
			copy();
			break;
		case 5:
			//1
			for (int i = 0; i < n/2; i++) 
				for (int j = 0; j < m/2; j++)
					tmp[i][j]=map[i+n/2][j];
			//2
			for (int i = 0; i < n/2; i++) 
				for (int j = m/2; j < m; j++)
					tmp[i][j]=map[i][j-m/2];
			//3
			for (int i = n/2; i < n; i++) 
				for (int j = m/2; j < m; j++)
					tmp[i][j]=map[i-n/2][j];
			//4
			for (int i = n/2; i < n; i++) 
				for (int j = 0; j < m/2; j++)
					tmp[i][j]=map[i][j+m/2];
			copy();
			break;
		case 6:
			//1
			for (int i = 0; i < n/2; i++) 
				for (int j = 0; j < m/2; j++)
					tmp[i][j]=map[i][j+m/2];
			//2
			for (int i = 0; i < n/2; i++) 
				for (int j = m/2; j < m; j++)
					tmp[i][j]=map[i+n/2][j];
			//3
			for (int i = n/2; i < n; i++) 
				for (int j = m/2; j < m; j++)
					tmp[i][j]=map[i][j-m/2];
			//4
			for (int i = n/2; i < n; i++) 
				for (int j = 0; j < m/2; j++)
					tmp[i][j]=map[i-n/2][j];
			copy();
			break;
		}
	}

	private static void copy() {
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < m; j++)
				map[i][j]=tmp[i][j];
	}
}