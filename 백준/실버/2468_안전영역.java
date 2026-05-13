package 실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int maxHeight = 0;
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int result = 0;
        
        for (int h = 0; h < maxHeight; h++) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > h) {
                        dfs(i, j, h);
                        // bfs(i, j, h);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }
        
        

    }// psvm

    static void dfs(int x, int y, int height) {

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            if (visited[nx][ny])
                continue;
            if (map[nx][ny] <= height)
                continue;

            dfs(nx, ny, height);

        }

    }

    static void bfs(int x, int y, int height) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, y });

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {

                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (map[nx][ny] <= height)
                    continue;

                visited[nx][ny] = true;

                queue.offer(new int[]{nx,ny});

            }
        }
    }
}// class