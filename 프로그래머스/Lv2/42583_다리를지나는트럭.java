package 프로그래머스.Lv2;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int total_time = 0;

        Queue<Integer> truckQueue = new ArrayDeque<>();
        Queue<Integer> bridgeQueue = new ArrayDeque<>();

        // 대기 트럭 큐
        for (int truck : truck_weights) {
            truckQueue.offer(truck);
        }

        int currentWeight = 0;

        // 처음에는 다리가 비어있으므로 0으로 채움
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        while (!bridgeQueue.isEmpty()) {

            // 1초 경과
            total_time++;

            // 다리 맨 앞 트럭 제거
            currentWeight -= bridgeQueue.poll();

            // 다음 트럭이 올라갈 수 있는지 확인
            if (!truckQueue.isEmpty()) {

                if (currentWeight + truckQueue.peek() <= weight) {

                    int truck = truckQueue.poll();

                    bridgeQueue.offer(truck);

                    currentWeight += truck;

                } else {

                    // 못 올라가면 빈 공간(0)
                    bridgeQueue.offer(0);
                }
            }

            // 대기 트럭이 없으면
            else {

                // 다리 위 트럭만 빠져나가도록 0 추가
                if (currentWeight > 0) {
                    bridgeQueue.offer(0);
                }
            }

            // 다리 위에도 없고 대기 트럭도 없으면 종료
            if (truckQueue.isEmpty() && currentWeight == 0) {
                break;
            }
        }

        return total_time;
    }
}