package 골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int r,c;
    static int count = 0;

    static void z(int x, int y, int size){
        
        if(size == 1){
            return;
        }

        int half = size / 2;

        if( r < x + half && c < y + half){
            z(x, y, half);
        }
        else if( r < x + half && c >= y + half){
            count += half * half;
            z(x, y + half, half);
        }
        else if( r >= x + half && c < y + half){
            count += 2 * half * half;
            z(x + half, y, half);
        }
        else{
            count += 3 * half * half;
            z(x + half, y + half, half);
        }

    }//z
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        z(0, 0 ,(int)Math.pow(2,n));

        System.out.println(count);

    }
}
