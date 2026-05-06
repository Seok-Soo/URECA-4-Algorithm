package 실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int paper[][];
    static int a = 0, b = 0, c = 0;

    static void cut(int x, int y, int size){

        int num = paper[x][y];
        boolean same = true;

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != num){
                    same = false;
                    break;
                }//if
            }//for
            if(!same)
                break;
        }//for

        if(same == true){
            if(num == -1)
                a++;
            else if(num == 0)
                b++;
            else
                c++;
            return;
        }

        int newsize = size / 3;

        cut(x, y, newsize);
        cut(x, y + newsize, newsize);
        cut(x, y + newsize*2, newsize);

        cut(x + newsize, y, newsize);
        cut(x + newsize, y + newsize, newsize);
        cut(x + newsize, y + newsize*2, newsize);

        cut(x + newsize*2, y, newsize);
        cut(x + newsize*2, y + newsize, newsize);
        cut(x + newsize*2, y + newsize*2, newsize);

        // for(int dx = 0; dx < 3; dx++){       //분할 이런식으로도 가능
        //    for(int dy = 0; dy < 3; dy++){
        //     cut(x + dx * newsize, y + dy * newsize, newsize);
        //     }
        // }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }//for
        }//for

        cut(0,0, n);

        System.out.println(a + "\n" + b + "\n" + c);

    }//psvm
    
}//class
