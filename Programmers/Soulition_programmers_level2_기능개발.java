package programmers;

import java.util.*;

class Soulition_programmers_level2_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> time = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int t=0;
            int work = progresses[i];
            while(work<100){
                work+=speeds[i];
                t++;
            }
            time.add(t);
        }
        
        while(!time.isEmpty()){
            int t = time.poll();
            int cnt = 1;
            while(!time.isEmpty() && time.peek()<=t){
                cnt++;
                time.poll();
            }
            ans.add(cnt);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
            answer[i] = ans.get(i);
        
        
        return answer;
    }
}