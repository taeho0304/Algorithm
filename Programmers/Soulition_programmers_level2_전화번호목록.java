package Algorithm;

import java.io.*;
import java.util.*;
public class Soulition_programmers_level2_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i<phone_book.length-1; i++){
        	if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}