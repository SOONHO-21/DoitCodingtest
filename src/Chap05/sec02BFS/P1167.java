package Chap05.sec02BFS;

import java.util.*;

public class P1167 {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //노드 개수
        A = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            A[i] = new ArrayList<Edge>();
        }
        for (int i=1; i<=N; i++){
            int S = sc.nextInt();
            while(true){    //while의 조건에 넣을거 없고 종료 조건을 내부에 맏길거면 true 넣기
                int E = sc.nextInt();
                if(E == -1)
                    break;
                int V = sc.nextInt();
                A[i].add(new Edge(E, V));
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int max = 1;
        for(int i=2; i<=N; i++){
            if(distance[max] < distance[i])
                max = i;
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();  //노드와 가중치 중에서 '노드'를 담는 큐
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(Edge next : A[now_node]) {
                int e = next.e;
                int v = next.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = v + distance[now_node];
                }
            }
        }
    }
}
class Edge {
    int e;
    int value;
    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}