package Chap08.sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_1 {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int t=0; t<N; t++) {
            int V = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            for(int i=1; i<=V; i++){
                A[i] = new ArrayList<>();
            }
            for(int i=0; i<E; i++){
                int start = Integer.parseInt(br.readLine());
                int end = Integer.parseInt(br.readLine());
                A[start].add(end);
                A[end].add(start);
            }
            for(int i=1; i<=V; i++){
                if(IsEven)
                    DFS(i);
                else
                    break;
            }
            if(IsEven)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    private static void DFS(int node) {
        visited[node] = true;
        for(int i : A[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;   //서로 다른 두 집합으로 두는 것. 0과 1로만 나뉨
                DFS(i);
            } else if(check[i] == check[node]) {    //이미 방문한 노드가 같은 집합에 속해있으면
                IsEven = false;                     //이분 그래프가 아닌 것
            }
        }
    }
}