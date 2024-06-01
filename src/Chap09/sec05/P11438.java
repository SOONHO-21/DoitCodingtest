package Chap09.sec05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11438 {
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
        kmax = 0;
        int temp = 1;
        while (temp <= N){
            temp <<= 1;
            kmax++;
        }

        parent = new int[kmax+1][N+1];
        BFS(1);     //parent[0][N+1]배열 최초 초기화

        for(int k=0; k<kmax; k++){
            for(int n=1; n<=N; n++){
                parent[k][n] = parent[k-1][parent[k-1][n]];     //점화식
            }
        }
        int M = Integer.parseInt(br.readLine());
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
        int level = 1;
        int now_size = 1;
        int count = 0;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : tree[now_node]){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    parent[0][i] = now_node;
                    depth[i] = level;
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
    private static int excuteLCA(int a, int b){
        if(depth[a] > depth[b]){    //더 깊은게 b가 되게 하기
            int temp = a;
            a = b;
            b = temp;
        }
        for(int k=kmax; k>=0; k--){     //depth 맞추기
            if(Math.pow(2, k) <= depth[b] - depth[a]){
                if(depth[a]<=depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }
        for(int k=kmax; k>=0; k--){     //조상 빠르게 찾기 로직
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int LCA = a;
        if(a != b)
            //k가 0까지 반복이 끝난 상태에서 다르니
            //바로 한 단계 위 노드가 최소 공통조상이 됨
            LCA = parent[0][LCA];
        return LCA;
    }
}