import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {

    static int arr[];
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n-1];

        cards(n);

        return;

    }//psvm

    static void cards(int n){
        for(int i = 1; i <= n; i++ ){

            queue.add(i);
        
        }//for

        while(!queue.isEmpty()){
            
            if(queue.size() == 1){
                System.out.print(queue.peek());
                break;
            }//if
            
            System.out.print( queue.poll() + " ");

            queue.offer(queue.poll());

        }//while
    }//cards
    
}//class
