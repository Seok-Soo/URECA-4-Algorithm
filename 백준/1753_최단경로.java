import java.io.*;
import java.util.*;

class Main {

        //정점의 개수 V
        //간선의 개수 E
        //3째줄 3개의 정수 (u, v, w)
        //w는 u에서 v로 가는 가중치
        //u와 v는 서로 다르며 w는 10 이하의 자연수

    static class Node implements Comparable<Node> {
        int v;      // 도착 정점
        int cost;   // 현재까지 누적 거리

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 기준 오름차순
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수

        int start = Integer.parseInt(br.readLine()); // 시작 노드

        // 1. 그래프 초기화
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 간선 입력 (방향 그래프!)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w)); // 단방향
        }

        // 3. 거리 배열
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        // 4. PriorityQueue
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 세팅
        dist[start] = 0;
        pq.add(new Node(start, 0));

        // 5. 다익스트라 시작
        while (!pq.isEmpty()) {

            Node current = pq.poll();
            int now = current.v;
            int cost = current.cost;

            // 🔥 핵심 1: 이미 더 좋은 경로 있으면 스킵
            if (dist[now] < cost) continue;

            // 현재 노드에서 갈 수 있는 곳 탐색
            for (Node next : graph[now]) {

                int nextNode = next.v;
                int newCost = cost + next.cost; // 🔥 누적

                // 🔥 핵심 2: 더 짧으면 갱신
                if (dist[nextNode] > newCost) {
                    dist[nextNode] = newCost;
                    pq.add(new Node(nextNode, newCost));
                }
            }
        }

        // 6. 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }
}