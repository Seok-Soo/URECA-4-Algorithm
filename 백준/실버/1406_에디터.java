package 실버;
import java.io.*;
import java.util.*;
//스택문제
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String s = br.readLine();

        // 초기 문자열 → 왼쪽 스택
        for (char c : s.toCharArray()) {
            left.push(c);
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            if (cmd.equals("L")) {
                if (!left.isEmpty()) right.push(left.pop());
            } 
            else if (cmd.equals("D")) {
                if (!right.isEmpty()) left.push(right.pop());
            } 
            else if (cmd.equals("B")) {
                if (!left.isEmpty()) left.pop();
            } 
            else if (cmd.startsWith("P")) {
                left.push(cmd.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder();

        // 왼쪽 → 결과
        for (char c : left) sb.append(c);

        // 오른쪽 → 뒤집어서 붙이기
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}



//시간초과
// class Main {
//     static int x;
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         String s = sc.next();
//         int n = sc.nextInt();
//         sc.nextLine();
//         x = s.length();
//         for (int i = 0; i < n; i++) {

//             String input = sc.nextLine();

//             if (input.startsWith("P")) {
//                 String[] cmd = input.split(" "); 
//                 s = s.substring(0,x) + (cmd[1]) + s.substring(x);
//                 x++;
//             } else if (input.equals("L")) {
//                 if (x <= 0) continue;
//                 x--;
//             } else if (input.equals("D")) {
//                 if (x >= s.length()) continue;
//                 x++;
//             } else if (input.equals("B")) {
//                 if (x <= 0) continue;
//                 s = s.substring(0, x - 1) + s.substring(x);
//                 x--;
//             }

//         }
//         System.out.println(s);

//     }// psvm

// }// class
