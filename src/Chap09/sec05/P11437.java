package Chap09.sec05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11437 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        }
    }
    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int next : tree[now_node]){
                if(visited[next] == false) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node;
                    depth[next] = level;
                }
            }
            count++;
            if(count == now_size){
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
    private static int excuteLCA(int n1, int n2){
        if(depth[n1] < depth[n2]){
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        while (depth[n1] != depth[n2]){
            n1 = parent[n1];
        }
        while (parent[n1] != parent[n2]){
            n1 = parent[n1];
            n2 = parent[n2];
        }
        return parent[n1];
    }
}