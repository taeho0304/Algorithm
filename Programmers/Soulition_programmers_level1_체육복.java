package PG;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Soulition_programmers_level1_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};

		int count = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }

        for (int k : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if (k == reserve[j] - 1 || k == reserve[j] + 1) {
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }

        System.out.println(n - lost.length + count); 
	}

}