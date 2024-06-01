package Chap08.sec01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325 {
    static ArrayList<Integer>[] A;
    static int N, M;
    static boolean visited[];
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[N+1];
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            BFS(i);
        }
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, answer[i]);
        }
        for(int i=1; i<=N; i++){
            if(answer[i] == max)
                System.out.println(i + " ");
        }
    }
    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            visited[now_node] = true;
            for(int i : A[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    answer[i]++;
                }
            }
        }
    }
}