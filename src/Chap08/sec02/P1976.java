package Chap08.sec02;

import java.util.Scanner;

public class P1976 {
    static int N;
    static int M;
    static int[][] dosi;
    static int[] route;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dosi = new int[N+1][N+1];
        route = new int[M+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                dosi[i][j] = sc.nextInt();
            }
        }
        for(int i=1; i<=M; i++){
            route[i] = sc.nextInt();
        }
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dosi[i][j] == 1){
                    union(i, j);
                }
            }
        }
        int index = find(route[1]);
        for(int i=2; i< route.length; i++){
            if(find(route[i]) != index){
                System.out.println("No");
                return;
            }
        }
        System.out.println("YES");
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    private static int find(int a){
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}