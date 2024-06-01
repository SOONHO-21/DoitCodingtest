package Chap09.sec01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P11725 {
    static int N;   //노드 개수
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=0; i<A.length; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
            A[b].add(a);
        }
        DFS(1);     //부모 노드 부터 DFS 시작
        System.out.println(Arrays.toString(answer));
    }
    static void DFS(int node){
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                answer[i] = node;   //DFS를 수행하면서 부모 노드를 정답 배열에 저장
                DFS(i);
            }
        }
    }
}