package 실버;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    
    static int map[][];
    static StringBuilder sb = new StringBuilder();

    static void compress(int x, int y, int size){

        int color = map[x][y];
        boolean same = true;

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(map[i][j] != color){
                    same = false;
                    
                }//if
            }//for
            if(!same) break;
        }//for

        if(same == true){
            sb.append(color);
            return;
        }

        sb.append("(");

        int newsize = size / 2;
        compress(x, y, newsize);
        compress(x, y + newsize, newsize);
        compress(x + newsize, y, newsize);
        compress(x + newsize, y + newsize, newsize);

        sb.append(")");
    }//compress


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        compress(0, 0, n);

        System.out.println(sb.toString());


    }

}
