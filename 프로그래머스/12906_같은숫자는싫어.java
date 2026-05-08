package 프로그래머스;

import java.util.*;

class Solution {
    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();

        for(int x : arr){
            queue.add(x);
        }

        list.add(queue.poll());

        while(!queue.isEmpty()){

            int now = queue.poll();

            if(now != list.get(list.size()-1)){
                list.add(now);
            }
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}