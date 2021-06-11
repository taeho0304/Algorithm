package Algorithm;

import java.util.*;

public class Soulition_programmers_level1_완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "mislav", "mislav", "ana" };

		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<completion.length; i++)
            if(!map.containsKey(completion[i])) map.put(completion[i],1);
		    else map.put(completion[i], map.get(completion[i])+1);
		
		for(int i=0; i<participant.length; i++)
			if(!map.containsKey(participant[i])) {
				System.out.println(participant[i]);
				return;
			} else if(map.get(participant[i])<=1) map.remove(participant[i]);
			else map.put(participant[i], map.get(participant[i])-1);

//		HashMap<String, String> map = new HashMap<>();
//
//		for (int i = 0; i < completion.length; i++)
//			map.put(completion[i], completion[i]);
//
//		for (int i = 0; i < participant.length; i++)
//			if (!map.containsKey(participant[i]))
//				System.out.println(participant[i]);
//			else
//				map.remove(participant[i]);
//		String answer = "";
	}
}
