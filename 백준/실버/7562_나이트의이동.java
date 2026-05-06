package 실버;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for( int i = 0; i < n; i++){

            int chessField = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start[] = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            
            st = new StringTokenizer(br.readLine());
            int destination[] = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            
            int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2};
            int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1};

            int dist[][] = new int[chessField][chessField];
            boolean visited[][] = new boolean[chessField][chessField];

            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[]{start[0],start[1]});

            visited[start[0]][start[1]] = true;
            dist[start[0]][start[1]] = 0;

            while(!queue.isEmpty()){

                int now[] = queue.poll();
                int x = now[0];
                int y = now[1];

                for(int j = 0; j < dx.length; j++){

                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    
                    if(nx < 0 || ny < 0 || nx >= chessField || ny >= chessField)
                        continue;
                    if(visited[nx][ny] == true)
                        continue;

                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;

                    queue.offer(new int[]{nx,ny});

                }//for

                
            }//while

            System.out.println(dist[destination[0]][destination[1]]);


        }//for

    }//psvm
}//class
