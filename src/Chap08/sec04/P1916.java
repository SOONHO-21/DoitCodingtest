package Chap08.sec04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
<<<<<<< HEAD

public class P1916 {
    static int N, M;
    static boolean[] visited;
    static int[] dist;      //최단거리 배열
    static ArrayList<Node>[] list;
=======
class node implements Comparable<node> {
    int targetNode;
    int value;

    node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(node o) {
        return value - o.value;
    }

}
public class P1916 {
    static int N, M;
    static boolean[] visited;
    static int[] distance;      //최단거리 배열
    static ArrayList<node>[] list;
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
<<<<<<< HEAD
        dist = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
=======

        list = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);   //dist 배열값 일괄 초기화

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<node>();
        }

        for(int i=0; i<M; i++){         //인접 리스트 초기화
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
<<<<<<< HEAD
            list[start].add(new Node(end, weight));
        }
        int startIndex = Integer.parseInt(br.readLine());
        int endIndex = Integer.parseInt(br.readLine());
=======

            list[start].add(new node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());

>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        bw.close();
    }
    public static int dijkstra(int start, int end) {
<<<<<<< HEAD
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
=======
        PriorityQueue<node> priorityQueue = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        priorityQueue.offer(new node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()){
            node now_node = priorityQueue.poll();
            int now_targetNode = now_node.targetNode;

            if(!visited[now_targetNode]){
                visited[now_targetNode] = true;
                for(int i=0; i<list[now_targetNode].size(); i++){
                    int next_vertex = now_node.targetNode;
                    int next_value = now_node.value;
                    if(distance[i] > distance[now_targetNode] + next_value) {
                        distance[i] = distance[now_targetNode] + next_value;
                        priorityQueue.add(new node(next_vertex, distance[now_node.value]));
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
                    }
                }
            }
        }
<<<<<<< HEAD
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
=======
        return distance[end];
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
    }
}