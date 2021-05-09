package com.ssafy.algo;

import java.io.*;

public class Soulution_BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s=s.replace("c=","1");
        s=s.replace("c-","1");
        s=s.replace("dz=","1");
        s=s.replace("d-","1");
        s=s.replace("lj","1");
        s=s.replace("nj","1");
        s=s.replace("s=","1");
        s=s.replace("s=","1");
        s=s.replace("z=","1");

		System.out.println(s.length());
	}

}
