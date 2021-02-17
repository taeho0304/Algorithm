package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_2164_카드2 {
	static int n, cnt;
	static int card[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		for(int i=1; i<=n; i++)
			card[i]=i;
		
		sc.close();
	}
}