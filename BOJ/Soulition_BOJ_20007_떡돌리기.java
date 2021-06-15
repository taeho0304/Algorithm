package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Soulition_BOJ_20007_떡돌리기 {
	static int N, M, X, Y;
	static boolean[] visited;
	static ArrayList<home>[] arr; // 연결 유무를 판단할 어레이 리스트
	static PriorityQueue<home> pq = new PriorityQueue<>(); // 우선순위 큐, 성현이의 집에서 출발하면서 가까운 거리순서 대로 활용할 예정
	static int[] dist;
	static final int max = Integer.MAX_VALUE;
	static int answer = 1;

	public static class home implements Comparable<home> {
		int number, dist;

		public home(int number, int dist) {
			super();
			this.number = number;
			this.dist = dist;
		}

		@Override
		public int compareTo(home o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		// 연결 리스트 관리
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		dist = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			arr[from].add(new home(to, dist)); // 양방향 연결
			arr[to].add(new home(from, dist));
		}

		// 1. 우선순위 큐로 성현이 집 시작으로부터 가까운 거리로 걸리는 거리 저장 해두기
		dijkstra();

		// 2. 가까운 순서대로 정렬하기
		Arrays.sort(dist);

		//print();

		// 3. 하나씩 방문하면서 day 증가
		visit();
		System.out.println(answer);
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	private static void visit() {
		// TODO Auto-generated method stub
		int totaldist =0;
		for (int i = 0; i < dist.length; i++) {
			// 가려고 하는 곳이 왕복거리를 포함해서 X안에 갈 수 없다면!? NO answer
			if ( dist[i]*2 > X ) {
				answer = -1;
				break;
			}
			// 방문한 왕복 거리 계속 더하다가.
			totaldist += dist[i]*2;
			
			// 그 거리가 X보다 크다면? == 하루안에는 못가잖아. 그러니까, 하루 더 추가해주고 totaldist는 현재 방문한 거리의 값으로 바꿔주자.
			if ( totaldist > X ) {
				answer++;
				totaldist = dist[i]*2;;
			}
			
		}

	}

	// 1.성현이의 집을 출발지로 가능한 모든 집 간의 거리를 최소값으로 정렬하자.
	private static void dijkstra() {
		Arrays.fill(dist, max);
		dist[Y] = 0; // 성현이의 집은 거리 0 이니까

		// 성현이의 집 큐에 먼저 넣기.
		pq.add(new home(Y, 0));

		while (!pq.isEmpty()) {

			// 1. 큐 꺼내고
			home cur = pq.poll();
			int curPos = cur.number;
			int curdist = cur.dist;

			// 2. 거기에서 연결된 모든 노드들 방문하면서 성현이의 집으로부터의 거리를 갱신하자.
			// 2-1) 여기에서 방문했다고 ㄹㅇ방문한거 아님
			for (int i = 0; i < arr[curPos].size(); i++) {
				int target = arr[curPos].get(i).number;
				int target_dist = arr[curPos].get(i).dist;

				// 1) 방문 하지 않았고, 이전 까지 거쳐서 걸린 거리가 기존에 저장된 값보다 작다면 갱신해주기 ==> 만약 작지 않으면 갱신할 필요 없음
				// 2) 그리고 우선순위 큐에 넣어주자.
				if (visited[target] == false && dist[target] > target_dist + curdist) {
					dist[target] = target_dist + curdist; // 갱신
					pq.add(new home(target, dist[target]));

				}

			}
			// 3. 꺼냈다. = 방문 처리
			visited[curPos] = true;

		}

	}
}