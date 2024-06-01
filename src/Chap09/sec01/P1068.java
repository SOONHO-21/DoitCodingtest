package Chap09.sec01;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068 {
    static int N, T;
    static int answer;
    static ArrayList<Integer>[] tree;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        answer = 0;
        int root = 0;
        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            if(temp == -1){
                root = i;
            } else {
                tree[temp].add(i);
                tree[i].add(temp);
            }
        }
        T = sc.nextInt();
        if(T == 0){
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }
    static void DFS(int number){
        visited[number] = true;
        int cNode = 0;
        for(int i : tree[number]){
            if(visited[i] == false && i != T){
                visited[i] = true;
                cNode++;
                DFS(i);
            }
        }
        if(cNode==0)
            answer++;
    }
}