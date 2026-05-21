package 실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxWater = 0;
        int map[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxWater = Math.max(map[i][j], maxWater); //Math.max(map[i][j], maxWater); 갱신안함
            } // for j
        } // for i

        Queue<int[]> q = new ArrayDeque<>();
        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };
        int countSafeArea = 0;
        for (int i = 0; i < maxWater; i++) {
            boolean visited[][] = new boolean[n][n];
            int temp = 0;

            // 물 높이마다 검사하면서 최대 안전영역 구하기
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k] == true) {
                        continue;
                    }
                    if(map[j][k] <= i)
                        continue;
                    
                    temp++;
                    q.offer(new int[] { j, k });
                    visited[j][k] = true;
                    while (!q.isEmpty()) {
                        int now[] = q.poll();
                        int x = now[0];
                        int y = now[1];
                        for (int l = 0; l < 4; l++) {
                            int nx = x + dx[l];
                            int ny = y + dy[l];
                            if (nx >= n || ny >= n || 0 > nx || 0 > ny)
                                continue;
                            if (visited[nx][ny] == true)
                                continue;
                            if (map[nx][ny] <= i)
                                continue;
                            visited[nx][ny] = true;
                            q.offer(new int[] { nx, ny });
                        }
                    }
                    
                }
                // for k
            }
            // for j
            countSafeArea = Math.max(temp, countSafeArea);
        }
        // for i
        System.out.print(countSafeArea);
    }// psvm
}// class