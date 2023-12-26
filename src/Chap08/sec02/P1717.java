package Chap08.sec02;

import java.util.Scanner;

public class P1717 {
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N+1];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            int question = sc.nextInt();    //0야니면 1
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(question == 0){
                union(a, b);
            } else {
                if(checkSum(a, b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
    private static void union(int a, int b){    //합치기 연산
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }
    private static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);    //대표 노드 수정
    }
    private static boolean checkSum(int a, int b){
        a = find(a);
        b = find(b);
        if(parent[a] == parent[b])  //a==b도 상관 X
            return true;
        return false;
    }
}