package Chap05.sec02BFS;

import org.w3c.dom.Node;

import java.util.*;

public class P1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;   //탐색 경로
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start_point = sc.nextInt(); //스타트를 하는 노드
        A = new ArrayList[N+1];

        for (int i=0; i<N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<N; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for (int i=0; i<N; i++){    //각 노드당 에지 정렬
            Collections.sort(A[i]);
        }
        visited = new boolean[N+1];
        DFS(start_point);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start_point);
    }
    static void DFS(int node){
<<<<<<< HEAD
        System.out.println(node);
=======
        System.out.println(node + " ");
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
        visited[node] = true;
        for(int i : A[node]){
            if(!visited[i])
                DFS(i);
        }
    }
<<<<<<< HEAD
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.println(now_Node + " ");
            for(int next : A[now_Node]){
                if(!visited[next]){
                    System.out.println(next);
                    queue.offer(next);
=======
    static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()){
            int now_node = queue.poll();
            System.out.println(now_node);
            for(int i : A[now_node]){
                if(!visited[i]) {   //아직 방문을 안 했을 경우에만
                    queue.add(i);
                    visited[i] = true;
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
                }
            }
        }
    }
}