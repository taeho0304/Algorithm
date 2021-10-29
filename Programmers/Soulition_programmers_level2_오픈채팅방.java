package PG;

import java.util.*;

public class Soulition_programmers_level2_오픈채팅방 {
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		/////////////////////////////////////////////////////
		HashMap<String, String> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		for(int i=0; i<record.length; i++) {
			String temp[] = record[i].split(" ");
			
			if(temp[0].equals("Enter")) {
				map.put(temp[1],temp[2]);
				list.add("님이 들어왔습니다.");
				list2.add(temp[1]);
			}else if (temp[0].equals("Leave")) {
				list2.add(temp[1]);
				list.add("님이 나갔습니다.");
			}else {
				map.put(temp[1],temp[2]);
			}
		}
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++)
			answer[i]=map.get(list2.get(i))+list.get(i);
		
//		return answer;
	}
}
