package PG;

import java.util.PriorityQueue;

public class Soulition_programmers_level1_없는숫자더하기 {

	public static void main(String[] args) {
		int[] numbers = { 1,2,3,4,6,7,8,0 };

		//////////
		int answer = 1+2+3+4+5+6+7+8+9;
        for(int i=0; i<numbers.length; i++)
            answer-=numbers[i];
		System.out.println(answer);
	}

}
