import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    static String T, P;
    static int[] skip;
    static List<Integer> answer = new ArrayList<>();

    // private static void makeSkip(String pattern) {

    // int idx1 = 1, idx2 = 0;
    // while (idx1 != pattern.length()) {

    // if (pattern.charAt(idx1) == pattern.charAt(idx2)) {// 문자가 같으면
    // // idx1++;
    // // idx2++;
    // // skip[idx1] = idx2
    // // 위 코드랑 아래랑 같음
    // skip[++idx1] = ++idx2;
    // } else if (idx2 == 0) { // 다른 경우 - 맨 처음부터 다른 경우
    // skip[++idx1] = idx2;
    // } else {// 다른 경우 - 몇 개 같다가 중간부터 다른 경우
    // idx2 = skip[idx2];
    // }
    // } // while

    // }

    static void makeSkip(String pattern) {
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = skip[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                skip[i] = ++j;
            }
        }
    }

    // private static void kmpSearch(String text, String pattern) {

    //     int tidx = 0, pidx = 0;

    //     while (tidx < text.length()) {
    //         if (text.charAt(tidx) == pattern.charAt(pidx)) {
    //             tidx++;
    //             pidx++;

    //         } else if (pidx == 0) {
    //             tidx++;

    //         } else {
    //             pidx = skip[pidx];
    //         } // if
    //     } // while

    //     if (pidx == pattern.length()) {
    //         answer.add(tidx - pidx);
    //         // System.out.printf("tidx : %d, pidx : %d,tidx - pidx : %d\n", tidx, pidx, tidx
    //         // - pidx)
    //     }

    // } // kmpSearch

    private static void kmpSearch(String text, String pattern){

    int tidx = 0, pidx = 0;

    while (tidx < text.length()) {

        if (text.charAt(tidx) == pattern.charAt(pidx)) {
            tidx++;
            pidx++;
        }

        if (pidx == pattern.length()) {
            answer.add(tidx - pidx);
            pidx = skip[pidx - 1]; // ← 중요
        } else if (tidx < text.length() && text.charAt(tidx) != pattern.charAt(pidx)) {
            if (pidx > 0) {
                pidx = skip[pidx - 1];
            } else {
                tidx++;
            }
        }
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextLine();
        P = sc.nextLine();
        skip = new int[P.length()];

        sc.close();

        makeSkip(P);
        kmpSearch(T, P);

        System.out.println(answer.size());
        for (int i : answer)
            System.out.print((i + 1) + " ");

    }// psvm

}// Main
