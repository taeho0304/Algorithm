package PG;

public class Soulition_programmers_level1_124나라의숫자 {

	public static void main(String[] args) {
		int n = 2;

		//////////
		String[] numbers = {"4", "1", "2"};
	      String answer = "";
	      
	      int num = n;
	      
	      while(num > 0){
	          int remainder = num % 3;
	          num /= 3;
	          
	          if(remainder == 0) num--;
	          
	          answer = numbers[remainder] + answer;
	      }

		System.out.println(answer);
	}

}
