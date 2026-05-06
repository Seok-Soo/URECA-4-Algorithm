import java.util.Scanner;

// class Main {

    static int N, M, V;
    static int [][] graph;
    static boolean [] visited;
    static StringBuilder strBuild;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new int[ N + 1 ][ N + 1 ];
        int nodeIdx1 = 0, nodeIdx2 = 0;
        for(int i = 0; i < M; i++){
            nodeIdx1 = sc.nextInt();
            nodeIdx2 = sc.nextInt();
            graph[nodeIdx1][nodeIdx2] = graph[nodeIdx2][nodeIdx1] = 1;
        }

        visited = new boolean[N + 1];
        strBuild = new StringBuilder();
        dfs(V);
        System.out.println(strBuild);

        visited = new boolean[N + 1];
        strBuild = new StringBuilder();
        bfs(V);
        System.out.println(strBuild);


        
        sc.close();

    }//psvm

    public static void dfs(int node){ // 재귀로 구현
        visited[node] = true;
        strBuild.append(node + " ");

        for(int next = 0; next < graph.length; next++){
            if( graph[node][next] == 1 && !visited[next]){
                dfs(next);
            }
        }//for

    }//dfs


    public static void bfs(int node){ // 큐로 구현
        
    }//bfs


}//class
