package 프로그래머스;

import java.util.Arrays;

class Solution {

    public static int apeach[];
    public static int tmp[] = new int[11];
    public static int max;

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];

        max = Integer.MIN_VALUE;

        apeach = new int[11];
        apeach = info.clone();

        dfs(0, n, answer);

        if (max == Integer.MIN_VALUE) {
            return new int[] { -1 };
        }

        return tmp;
    }

    static void dfs(int idx, int n, int ryan[]) {

        if (idx == 11) {
            ryan[10] += n;

            int diff = calc(ryan, apeach);
            updateResult(ryan, diff);

            if (n > 0) {
                ryan[10] -= n;
            }

            return;
        }

        if (n > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            dfs(idx + 1, n - ryan[idx], ryan);
            ryan[idx] = 0;
        }

        dfs(idx + 1, n, ryan);

    }

    static int calc(int[] ryan, int[] apeach) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            if (ryan[i] == 0 && apeach[i] == 0)
                continue;
            if (ryan[i] > apeach[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        } // for

        return ryanScore - apeachScore;
    }

    static void updateResult(int[] arr, int diff) {
        if (diff <= 0)
            return;

        if (diff > max) {
            max = diff;
            tmp = arr.clone();
            return;
        }

        if (diff == max) {
            if (isBetter(arr, tmp)) {
                tmp = arr.clone();
            }
        }
    }

    static boolean isBetter(int[] a, int[] b) {

        for (int i = 10; i >= 0; i--) {
            if (a[i] > b[i])
                return true;
            if (a[i] < b[i])
                return false;
        }
        return false;
    }

    public static void main(String[] args) {

        // 테스트 케이스
        int[] nArr = { 5, 1, 9, 10 };

        int[][] infoArr = {
                { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 }
        };

        for (int t = 0; t < nArr.length; t++) {
            int n = nArr[t];
            int[] info = infoArr[t];

            int[] result = solution(n, info);

            System.out.println("n = " + n);
            System.out.println("info = " + Arrays.toString(info));
            System.out.println("result = " + Arrays.toString(result));
            System.out.println("----------------------");
        }
    }

}

// 순서는 어피치 n발 라이언 n발
// 맞힌 갯수가 동률일땐 어피치가 점수를 가져감
// 최종점수가 같은 경우 어피치 우승
// info[] 의 원소 합은 n
// info[0]은 10점으로 idx가 증가할수록 낮은점수
