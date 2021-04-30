package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_BOJ_1786_찾기 {
	static int cnt;
	static ArrayList<Integer> li;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		li = new ArrayList<>();
		System.out.println(cnt);
		KMP(origin, pattern);
	}


	private static void KMP(String org, String ptn) {
		int pi[] = getPi(ptn);
		int j = 0;
		for (int i = 0; i < org.length(); i++) {
			while (j > 0 && org.charAt(i) != ptn.charAt(j)) {
				j = pi[j - 1];
			}
			if (org.charAt(i) == ptn.charAt(j)) {
				if (j == ptn.length() - 1) {
					++cnt;
					li.add(i - j + 1);
					j = pi[j];
				}
				else
					j++;
			}

		}

	}
	

	private static int[] getPi(String ptn) {
		int[] pi = new int[ptn.length()];
		int j=0;
		for(int i=1;i<ptn.length();i++) {
			while(j>0 && ptn.charAt(i)!=ptn.charAt(j)) {
				j=pi[j-1];
			}
			if(ptn.charAt(i)==ptn.charAt(j))
				pi[i]=++j;
		}
		return pi;
	}

}
