package PG;

public class Soulition_programmers_level1_핸드폰번호가리기 {

	public static void main(String[] args) {
		String phone_number = "01033334444";

		String answer = "";
		String[] a = phone_number.split("");
		for (int i = 0; i < a.length; i++) {
			if (i < (a.length - 4))
				answer += "*";
			else
				answer += a[i];
		}

		System.out.println(answer);
	}

}
