import java.util.Scanner;

class Main{
    static int count;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int onepan = sc.nextInt();

        hanoi(onepan, 1 ,2,3 );
        
        sc.close();
        
    }//psvm

    public static void hanoi(int n, int left, int mid, int right){

        if(n == 1){
            System.out.println(left + " " + right);
            count++;
            return;
        }
        
        hanoi(n-1, left, right, mid);
        System.out.println(left + " " + right);
        count++;
        hanoi(n-1, mid, left, right);
        

        
        return;
    }
}//Main