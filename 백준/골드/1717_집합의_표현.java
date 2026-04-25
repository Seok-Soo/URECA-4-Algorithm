package 골드;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int [] nodes;

    private static boolean union(int nodeIdx1, int nodeIdx2){

        int rootIdx1 = find(nodeIdx1);
        int rootIdx2 = find(nodeIdx2);
        if(rootIdx1 == rootIdx2) return false;

        nodes[rootIdx2] = rootIdx1;
        return true;
    }//union

    private static int find(int nodeIdx){
        if( nodes[nodeIdx] == nodeIdx) return nodeIdx;
        
        return nodes[nodeIdx] = find(nodes[nodeIdx]);
    }//find

    public static void main(String[] args)  throws Exception {
        StringBuilder strBuild = new StringBuilder();

        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bufRead.readLine(), " ");

        N = Integer.parseInt( token.nextToken());
        M = Integer.parseInt( token.nextToken());

        nodes = new int[N + 1];
        for(int i = 0; i <= N; i++){
            nodes[i] = i;
        }

        int command, nodeIdx1, nodeIdx2;
        for(int i = 0; i< M; i++){
            token = new StringTokenizer(bufRead.readLine(), " ");
            command = Integer.parseInt( token.nextToken());
            nodeIdx1 = Integer.parseInt( token.nextToken());
            nodeIdx2 = Integer.parseInt( token.nextToken());

            switch(command){
                case 0 :
                    union(nodeIdx1, nodeIdx2);
                    break;
                case 1 :
                    strBuild.append( find(nodeIdx1) == find(nodeIdx2) ? "YES\n" : "NO\n");
                    break;
            }//switch
        }//for

        System.out.println( strBuild.toString());

        

    }
    
}
