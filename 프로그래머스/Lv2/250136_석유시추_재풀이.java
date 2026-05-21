package 프로그래머스.Lv2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;

        int n = land.length;
        int m = land[0].length;
        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };
        boolean visited[][] = new boolean[n][m];
        int oil[] = new int[m];
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(land[i][j] == 0 || visited[i][j])
                    continue;
                Queue<int[]> q = new ArrayDeque<>();

                q.offer(new int[] { i, j });
                visited[i][j] = true;

                Set<Integer> set = new HashSet<>();
                int count = 1;

                set.add(j);

                while (!q.isEmpty()) {// 한 석유덩어리 탐색
                    int now[] = q.poll();

                    for (int k = 0; k < 4; k++) {

                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];

                        if(nx >= n || ny >= m || nx < 0 || ny < 0)
                            continue;
                        if(visited[nx][ny] == true)
                            continue;
                        if(land[nx][ny] == 0)
                            continue;

                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        
                        count++;
                        set.add(ny);

                    } // for(k)

                } // while

                for(int a : set){
                    oil[a] += count;
                }

            } // for(j)

        } // for(i)

        for(int a : oil){
            answer = Math.max(a, answer);
        }

        return answer;
    }//solution
}