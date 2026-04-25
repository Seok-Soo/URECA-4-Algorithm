package 브론즈;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < n; i++){
            String s = bf.readLine();    
            int count = 0;
            int sum = 0;
            for (int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'O'){
                    sum += ++count;
                }else count = 0;

            }
            
            System.out.println(sum);
        }


    }
}