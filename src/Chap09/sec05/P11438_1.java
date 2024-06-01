package Chap09.sec05;

import javax.naming.ldap.PagedResultsControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11438_1 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax;    //트리의 최대 높이
    static int[][] parent;
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
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
        int kmax = 0;
        int temp = 1;
        while (temp <= N){
            temp <<= 1;
            kmax++;
        }
        parent = new int[kmax+1][N+1];
        BFS(1);     //parent[0][N+1]배열 최초 초기화
        //점화식으로 parent
        for(int i=1; i<kmax; i++){
            for (int j=1; j<N; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
        int M = Integer.parseInt(br.readLine());    //질의의 수
        for(int i=0; i<M; i++){
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
        int count = 0;
        int level = 1;
        int now_size = 1;
        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int next : tree[now_node]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    parent[0][next] = now_node;
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
    private static int excuteLCA(int a, int b) {
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        for(int k=kmax; k>=0; k--){
            if(Math.pow(2, k) <= depth[a] - depth[b]){
                if(depth[b] <= depth[parent[k][a]]){
                    a = parent[k][a];
                }
            }
        }
        for(int k = kmax; k>=0; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if(a!=b)
            LCA = parent[0][a];
        return LCA;
    }
}