package Chap08.sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class P1707 {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
<<<<<<< HEAD
        for(int t=0; t<K; t++){
=======
        for(int i=0; i<K; i++){
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);   //노드 개수
            int E = Integer.parseInt(s[1]);   //에지 개수
            check = new int[N+1];
            A = new ArrayList[N+1];
            visited = new boolean[N+1];
            IsEven = true;
            for(int j=1; j<N; j++){
<<<<<<< HEAD
                A[j] = new ArrayList<Integer>();
=======
                A[i] = new ArrayList<Integer>();
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
            }
            for(int j=0; j<E; j++){     //인접 리스트 노드 연결
                s = br.readLine().split(" ");
                int Start = Integer.parseInt(s[0]);
                int End = Integer.parseInt(s[1]);   //어차피 s에 입력될 숫자는 무조건 2개다
                A[Start].add(End);
                A[End].add(Start);
            }
            //주어진 그래프가 1개로 연결되어있다는 보장이 없음, 모든 노두에서 수행
            for(int j=0; j<N; j++){
                if(IsEven)
                    DFS(1);
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
        for(int i : A[node]){
            if(!visited[i]){
                check[i] = (check[node] + 1) % 2;   //이전 노드와 다른 집합으로 분리
                DFS(i);
            }
            else if(check[i] == check[node])
                IsEven = false;
        }
    }
}