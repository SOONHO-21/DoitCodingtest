package Chap05.sec02BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1167 {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //노드 개수
        A = new ArrayList[N];
        for (int i=0; i<N; i++){
            A[i] = new ArrayList<Edge>();
        }
        for (int i=0; i<N; i++){
            int S = sc.nextInt();
            while(true){    //while의 조건에 넣을거 없고 종료 조건을 내부에 맏길거면 true 넣기
                if(S == -1)
                    break;
                int E = sc.nextInt();
                int V = sc.nextInt();
                A[i].add(new Edge(E, V));
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int max=1;
        for (int i=2; i<=N; i++){   //distance배열에서 가장 큰 값의 인덱스(가장 거리가 먼 노드) 구하기
            if(distance[max] < distance[i])
                max = i;
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
    }
    static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while (queue.isEmpty()){
            int now_node = queue.poll();
            for(Edge i : A[now_node]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    queue.add(e);
                    visited[e] = true;
                    distance[e] = v + distance[now_node];  //현재 노드에서 기존 가중치 + 현재 노드 가중치
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