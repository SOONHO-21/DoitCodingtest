package Chap08.sec04;

import java.awt.datatransfer.FlavorListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
    public static int V, E, K;
    public static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Edge> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        distance = new int[V+1];
        visited = new boolean[V+1];
        for(int i=1; i<V; i++)
            list[i] = new ArrayList<Edge>();
        for(int i=1; i<V; i++)
            distance[i] = Integer.MAX_VALUE;

        for(int i=1; i<V; i++){     //가중치가 있는 인접 리스트 초기화 하기
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        priorityQueue.add(new Edge(K, 0));  //K를 시작점으로 설정하기
        distance[K] = 0;
        //다 익스트라 알고리즘 구현 부분
        while (!priorityQueue.isEmpty()){
            Edge now = priorityQueue.poll();
            int n_v = now.vertex;
            if(visited[n_v])
                continue;
            visited[n_v] = true;
            for(int i=0; i<list[n_v].size(); i++){
                Edge tmp = list[n_v].get(i);
                if(distance[tmp.vertex] > distance[n_v] + tmp.value) {
                    distance[tmp.vertex] = distance[n_v] + tmp.value;
                    priorityQueue.add(new Edge(tmp.vertex, distance[tmp.vertex]));
                }
            }
        }
        for(int i=0; i<V; i++){
            if(visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}
class Edge implements Comparable<Edge>{     //PriorityQueue의 정렬 기준 잡기
    int vertex, value;
    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.value > o.value) return 1;
        return -1;
    }
}