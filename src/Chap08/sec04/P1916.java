package Chap08.sec04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {
    static int N, M;
    static boolean[] visited;
    static int[] dist;      //최단거리 배열
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        int startIndex = Integer.parseInt(br.readLine());
        int endIndex = Integer.parseInt(br.readLine());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        bw.close();
    }
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            int now = now_node.targetNode;
            if(!visited[now]){
                visited[now] = true;
                for(Node next : list[now]){
                    if(!visited[next.targetNode] && dist[next.targetNode] >
                            dist[now] + next.value) {
                        dist[next.targetNode] = dist[now] + next.value;
                        pq.add(new Node(next.targetNode, dist[next.targetNode]));
                    }
                }
            }
        }
        return dist[end];
    }
}
class Node implements Comparable<Node> {
    int targetNode;
    int value;
    Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}