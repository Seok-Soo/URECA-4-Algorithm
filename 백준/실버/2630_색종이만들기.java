package 실버;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    static int paper[][];
    static int white, blue;

    static void cut(int x, int y, int size){
        int color = paper[x][y];
        boolean same = true;
        for( int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != color){
                    same = false;
                    break;
                }//if
            }//for
            if(!same) break;
        }//for

        if (same == true){
            if (color == 0)
                white++;
            else
                blue++;
            return;
        }

        int newsize = size / 2;

        cut(x,y,newsize);
        cut(x, y + newsize, newsize);
        cut(x + newsize, y, newsize);
        cut(x + newsize, y + newsize, newsize);


    }//cut

    public static void main(String[] args) throws Exception{
        
        white = 0;
        blue = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
            
        }
        
        cut(0,0,n);

        System.out.println(white);
        System.out.println(blue);

    }//psvm
    
}//class
