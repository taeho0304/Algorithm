package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Soulition_BOJ_1662_압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Integer> len = new Stack<>();
		Stack<Integer> mul = new Stack<>();

		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				len.add(cnt - 1);
				mul.add(str.charAt(i - 1) - '0');
				cnt = 0;
			} else if (c == ')')
				cnt = len.pop() + mul.pop() * cnt;
			else
				cnt++;
		}
		System.out.print(cnt);
	}
}