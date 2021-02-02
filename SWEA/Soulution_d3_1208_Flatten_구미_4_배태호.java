package com.ssafy.io;

import java.io.*;
import java.util.*;

public class Soulution_d3_1208_Flatten_구미_4_배태호 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1289.txt"));
		Scanner sc = new Scanner(System.in);
		int box[]=new int [100];
		
		for(int tc=0; tc<10; tc++) {
			int num = sc.nextInt();
			for(int i=0; i<100; i++)
				box[i]=sc.nextInt();
			
			Arrays.sort(box);
			
			for(int i=0; i<num; i++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
			System.out.println("#"+(tc+1)+" "+(box[99]-box[0]));
		}
		sc.close();
	}
}