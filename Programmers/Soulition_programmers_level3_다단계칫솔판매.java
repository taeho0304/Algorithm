package PG;

import java.util.*;

public class Soulition_programmers_level3_다단계칫솔판매 {
	
	public static void main(String[] args) {

		String[] enroll= {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller= {"young", "john", "tod", "emily", "mary"};
		int[] amount= {12, 4, 2, 5, 10};

		/////////////////////////////////////////////////////
		HashMap<String, Person> people = new HashMap<>();
        int[] answer = new int[enroll.length];
        
        people.put("-", new Person("-"));
        for(int i = 0; i < enroll.length; i++)
            people.put(enroll[i], new Person(enroll[i]));
        
        for(int i = 0; i < referral.length; i++)
            people.get(enroll[i]).parent = people.get(referral[i]);
        
        for(int i = 0; i < seller.length; i++)
            addProfit(people.get(seller[i]), amount[i] * 100);
        
        for(int i = 0; i < enroll.length; i++)
            answer[i] = people.get(enroll[i]).profit;
        
        System.out.println(answer);
    }
    
    public static void addProfit(Person person, int profit){
        int profit_for_parent = profit / 10;
        if(profit_for_parent != 0 && person.parent != null){
            person.profit += profit - profit_for_parent;
            addProfit(person.parent, profit_for_parent);
        }else{
            person.profit += profit;
        }
    }
   
}
class Person{
    String name;
    Person parent;
    int profit;
    public Person(String name){
        this.name = name;
        this.parent = null;
        this.profit = 0;
    }  
}