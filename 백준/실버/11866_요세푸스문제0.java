import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Josephus(n, k);
    }// psvm

    static void Josephus(int n, int k){

        Queue<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        sb.append('<');
        
        while(!queue.isEmpty()){
            for(int i = 1; i < k; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            if(!queue.isEmpty())
                sb.append(", ");
                
        }
        sb.append(">");
        System.out.print(sb);
    }
}
// class