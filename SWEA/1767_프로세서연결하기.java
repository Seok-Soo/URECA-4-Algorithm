package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int maxinos[][] = new int[N][N];

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    maxinos[i][j] = Integer.parseInt(st.nextToken());
                    // System.out.print(maxinos[i][j] + " "); //입력 확인용
                } // for(int j = 0; j < N; j++)
                  // System.out.println(); //입력 확인용
            } // for(int i = 0; i < N; i++)

            // ---------- 여기까지가 입력 -------------------

            int dx[] = { 1, -1, 0, 0};
            int dy[] = { 0, 0, 1, -1};

            int count = 0;

            int dist[][] = new int[N][N];
            int visited[][] = new int[N][N];

            Queue<int[]> queue = new ArrayDeque<>();















        } // for(int t = 0; t < T; t++)

    }// psvm

}// class