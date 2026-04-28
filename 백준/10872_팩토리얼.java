import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(factorial(n));
        
        System.out.print(sb);
    }

    private static int factorial(int n){
        
        if ( n <= 1)
            return 1;
        
        return n * factorial(n - 1);

    }

}
