package 브론즈;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine(), "");

        int n = Integer.parseInt(bf.readLine());
        
        String s = bf.readLine();
        int sum = 0;
        for(int i = 0; i < n; i++){
            
            sum += (s.charAt(i) - '0'); 

        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        System.out.println(sb);
    }
    
}
