
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 위상 정렬 - Kahn's Algorithm - 진입차수 0인 노드를 큐에 넣고 하나씩 제거하면서 순서를 만드는 위상 정렬 알고리즘
class Main{
	static int N, M; // N : 노드의 수, M : 간선의 수
	static int inDegree[]; // 진입차수 - inDegree[3]==2; -> 3번 노드로 들어오는 간선이 2개
	static List<Integer>[] g; // 인접리스트 -> g[1]==3; -> 1번 노드의 뒤의 노드 목록

	static void topologySort(){
		Queue<Integer> que = new ArrayDeque<Integer>();
		StringBuilder strBuild = new StringBuilder();

		for (int i = 1; i <= N; i++) { // 진입 차수가 0인 노드를 큐에 삽입
			if( inDegree[i] == 0 ) que.offer( i );
		} // for

		while ( !que.isEmpty() ) {

			int cur = que.poll();
			strBuild.append(cur).append(" ");

			for (int next : g[cur]) {
				if( --inDegree[next] == 0 ) que.offer( next ); // if
			} // for

		} // while

		System.out.println( strBuild );
	} // topologySort

	public static void main(String[] args) throws Exception{
		BufferedReader bufRead = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer( bufRead.readLine(), " " );

		N = Integer.parseInt( token.nextToken() );
		M = Integer.parseInt( token.nextToken() );

		g = new ArrayList[ N + 1 ]; // 0번지 버림, 학생 번호는 1번부터
		for(int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		} // for

		inDegree = new int[ N + 1 ];

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer( bufRead.readLine(), " " );

			int a = Integer.parseInt( token.nextToken() );
			int b = Integer.parseInt( token.nextToken() );

			g[a].add(b);	 // a가 b보다 앞
			inDegree[b]++;   // b로 들어오는 간선 증가
		}

		bufRead.close();

//		System.out.println("g : " + Arrays.toString(g));
//		System.out.println("inDegree : " + Arrays.toString(inDegree));

		topologySort();
	} // main

} // class

/*
3 2
1 3
2 3
*/

/*
4 2
4 2
3 1
*/