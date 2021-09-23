package PG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Soulition_programmers_level1_숫자문자열과영단어 {

	public static void main(String[] args) {
		String s = "one4seveneight";
		
		String[]  num= {"0","1","2","3","4","5","6","7","8","9"};
	    String[] word= {"zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
	        for (int i = 0 ; i <10 ; i++){
	            s = s.replace(word[i] , num[i]);
	        }
	        System.out.println(s);
	    
	}

}