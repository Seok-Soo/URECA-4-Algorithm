package 실버;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int stair[] = new int[n];

        for(int i = 0; i < n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[n];

        dp[0] = stair[0];

        if( n >= 2){
            dp[1] = stair[0] + stair[1];
        }
        if( n >= 3){
            Math.max(stair[0] + stair[2], stair[1] + stair[2]);
        }

        for(int i = 3; i < n; i++){
            int a = dp[i-2] + stair[i];
            int b = dp[i-3] + stair[i-1] + stair[i];

            dp[i] = Math.max(a,b);
        }

        System.out.println(dp[n-1]);

    }
    
}

// 점화식
// dp[i]=max(dp[i−2]+stairs[i], dp[i−3]+stairs[i−1]+stairs[i])

// 수도코드
// 입력
// N ← 계단 개수
// stairs[1..N] ← 각 계단 점수

// 배열 생성
// dp[1..N]

// 초기값 설정
// dp[1] = stairs[1]

// if N >= 2
//     dp[2] = stairs[1] + stairs[2]

// if N >= 3
//     dp[3] = max(
//         stairs[1] + stairs[3],
//         stairs[2] + stairs[3]
//     )

// 점화식
// for i = 4 ~ N

//     case1 = dp[i-2] + stairs[i]
//     // 한 칸 전을 밟지 않고 오는 경우

//     case2 = dp[i-3] + stairs[i-1] + stairs[i]
//     // 연속 3칸 방지를 위해
//     // i-3 → i-1 → i 로 오는 경우

//     dp[i] = max(case1, case2)

// 출력
// dp[N]