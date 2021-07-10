package programmers;

import java.util.*;

public class Soulition_programmers_level1_크레인인형뽑기 {
		
	public static void main(String[] args) {
		Stack<Integer> st= new Stack<>();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves= {1,5,3,5,1,2,1,4};

		/////////////////////////////////////////////////////
		int ans=0;
		for(int i=0; i<moves.length; i++) 
			for(int j=0; j<board.length; j++) {
				if(board[j][moves[i]-1]!=0 ) {
					st.push(board[j][moves[i]-1]);
					board[j][moves[i]-1]=0;
					if(st.size()>1&&st.get(st.size()-1)==st.get(st.size()-2)) {
						ans+=2;
						st.pop();
						st.pop();
					}
					break;
				}
				
			}
		
		System.out.println(ans);

	}
}
