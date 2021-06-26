package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Soulition_programmers_level3_합승택시요금 {
  static class Node implements Comparable<Node> {
    //
    int idx, dist;

    public Node(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.dist, o.dist);
    }
  }

  static int N, INF;
  static int[][] graph;

  public static void main(String[] args) {
    int[][] fares = new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
        { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
    System.out.println(solution(6, 4, 6, 2, fares));

  }

  static int solution(int n, int s, int a, int b, int[][] fares) {
    N = n;
    INF = 987654321;
    graph = new int[N + 1][N + 1];

    // 연결되어있지 않은 노드를 표시하기 위해 최대값으로 초기화
    for (int i = 0; i <= N; i++) {
      Arrays.fill(graph[i], INF);
    }

    for (int[] far : fares) {
      int n1 = far[0];
      int n2 = far[1];
      int dist = far[2];

      // 양방향 그래프 적용
      graph[n1][n2] = dist;
      graph[n2][n1] = dist;
    }

    // 출발지와 도착지를 시작점으로 잡고 모든 정점에 대한 최소 이동 경로 구하기
    // 양방향이기 때문에 sDist[a] = s <->
    int[] sDist = dijkstra(s);
    int[] aDist = dijkstra(a);
    int[] bDist = dijkstra(b);
    
    // 1. 합승하지 않고 각자 따로 갔을 때 : S -> A, S -> B
    int noShare = sDist[a] + sDist[b];

    // 2. 합승해서 가기 S -> i + i -> A + i -> B
    int share = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      // 출발지에서 경유지로 가는 길이나 경유지에서 도착지로 가는 길이 하나라도 없으면 이동할 수 없음
      if (sDist[i] == INF || aDist[i] == INF || bDist[i] == INF)
        continue;

      // 출발지에서 경유지 i까지 같이 가고, i에서부터 각자 도착지 A, B로 가는 경우의 수 중 최소값
      share = Math.min(share, sDist[i] + aDist[i] + bDist[i]);
    }

    return Math.min(noShare, share);
  }

  /**
   * 매개변수 from : 출발지
   * 다익스트라 : 출발지 ~ 모든 정점으로의 최소 이동 경로
   **/
  public static int[] dijkstra(int from) {
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    // from에서 각 도착지로 가기 위한 최소 경로 값 들어있음
    int[] dist = new int[N + 1];
    boolean[] visited = new boolean[N + 1];

    Arrays.fill(dist, INF);

    dist[from] = 0;
    pq.add(new Node(from, dist[from]));

    while (!pq.isEmpty()) {
      int here = pq.peek().idx;
      int cost = pq.peek().dist;
      pq.poll();

      if (cost > dist[here])
        continue;

      for (int i = 1; i <= N; i++) {
        if (graph[here][i] != INF && !visited[i]) {
          if (dist[i] > (dist[here] + graph[here][i])) {
            dist[i] = dist[here] + graph[here][i];
            pq.add(new Node(i, dist[i]));
          }
        }
      }

      visited[here] = true;
    }

    return dist;
  }

}