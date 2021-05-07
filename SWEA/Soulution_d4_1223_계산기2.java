package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d4_1223_계산기2 {
	static int N, len;
	static int[][] sq, dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Queue<Pair> queue;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> op;
		Stack<Integer> calc;
		int N;

		for (int tc = 1; tc <= 10; tc++) {
			op = new Stack<>();
			calc = new Stack<>();
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			for (char ch : str.toCharArray()) {
				if (ch >= '0' && ch <= '9')
					calc.add(ch - '0');
				else if (ch == '*') {
					while (!op.empty() && op.peek() == '*') {
						op.pop();
						calc.add(calc.pop() * calc.pop());
					}
					op.push(ch);
				} else if (ch == '+') {
					while (!op.empty() && (op.peek() == '*' || op.peek() == '+')) {
						char c = op.pop();
						if (c == '*')
							calc.add(calc.pop() * calc.pop());
						else if (c == '+')
							calc.add(calc.pop() + calc.pop());
					}
					op.push(ch);
				}
			}

			while (!op.isEmpty()) {
				char c = op.pop();
				if (c == '*')
					calc.add(calc.pop() * calc.pop());
				else if (c == '+')
					calc.add(calc.pop() + calc.pop());
			}

			System.out.println("#" + tc + " " + calc.pop());
		}
	}
}