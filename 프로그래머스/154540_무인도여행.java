package 프로그래머스;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Solution {

    static int map[][];

    public int[] solution(String[] maps) {

        int[] answer = {};

        int n = maps.length;
        int m = maps[0].length();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = c - '0';

            } // for

        } // for

        int dx[] = { 1, -1, 0, 0};
        int dy[] = { 0, 0, 1, -1};
        boolean visited[][] = new boolean[n][m];

        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                Queue<int[]> queue = new ArrayDeque<>();
                
                if (map[i][j] == 0 || visited[i][j] == true) continue;

                int sum = map[i][j];
                queue.offer(new int[] { i, j });
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int now[] = queue.poll();
                    int x = now[0];
                    int y = now[1];

                    for(int k = 0; k < 4; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if(nx >= n || ny >= m || ny < 0 || nx < 0)
                            continue;
                        if(map[nx][ny] == 0)
                            continue;
                        if(visited[nx][ny] == true)
                            continue;

                        sum += map[nx][ny];

                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx,ny});

                    }//for
                } // while
                result.add(sum);
            } //
        } //

        answer = new int[result.size()];
        if (result.isEmpty()){
            return answer = new int[] {-1};
        }
        
        Collections.sort(result);
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;

    }// solution
}// Solution