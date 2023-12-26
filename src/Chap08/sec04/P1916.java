package Chap08.sec04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);   //dist 배열값 일괄 초기화

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<node>();
        }

        for(int i=0; i<M; i++){         //인접 리스트 초기화
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        bw.close();
    }
    public static int dijkstra(int start, int end) {
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
                    }
                }
            }
        }
        return distance[end];
    }
}