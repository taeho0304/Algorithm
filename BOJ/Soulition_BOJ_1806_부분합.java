package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Soulition_BOJ_1806_부분합 {
	 private static int[] arr;
	    private static int n;
	    private static long s;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        s = sc.nextLong();
	        arr = new int[n];
	        for (int i = 0; i <n ; i++) {
	            arr[i] = sc.nextInt();
	        }
	 
	        int ans = 100001, sum = 0;
	        int left = 0, right =0;
	        //  left, right 포인터로 합이 s이상 일때 right-left가 제일 작은것을 찾는다.
	        while(true){
	            if(sum >= s){// s를 찾아야하는데 지금까지 연속해서 더한 부분합이 더 크다면 leftpointer를 옮겨주고, 옮겼으므로 sum에서 빼준다.
	                sum -= arr[left];
	                ans = Math.min(ans, (right- left));
	                left++;
	            } else if(right == n) {
	                break;
	            }else{
	                sum += arr[right];
	                right++;
	            }
	        }
	 
	        if(ans == 100001){ // 처음에 초기화한 조건 그대로라는 이야기는 조건에 만족하는게 없다는 뜻, 그러므로 0출력
	            System.out.println(0);
	        }else {
	            System.out.println(ans);
	        }
	    }
	}