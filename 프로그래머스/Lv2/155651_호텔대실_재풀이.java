package 프로그래머스.Lv2;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int nowRoom = 0;
        int n = book_time.length;

        // 시작시간 기준 정렬
        Arrays.sort(book_time, (o1, o2) -> {
            return o1[0].compareTo(o2[0]);
        });

        // 입실, 퇴실 시간 분리
        LocalTime enter[] = new LocalTime[n];
        LocalTime exit[] = new LocalTime[n];
        // 값 입력
        for (int i = 0; i < n; i++) {
            enter[i] = LocalTime.parse(book_time[i][0]);
            exit[i] = LocalTime.parse(book_time[i][1]);
            if(exit[i].isBefore(LocalTime.parse("23:49"))){
                exit[i] = exit[i].plusMinutes(10);
           }else{
                exit[i] = LocalTime.parse("23:59");
            } 

        }

        PriorityQueue<LocalTime> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            while (!pq.isEmpty() && !enter[i].isBefore(pq.peek())) {
                pq.poll();
            }
            pq.offer(exit[i]);

            nowRoom = pq.size();
            answer = Math.max(answer, nowRoom); 

        }

        return answer;
    }
}