package Chap05.sec01DFS;


import java.sql.Array;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;

public class P11004 {
    static boolean visited[];
    static ArrayList<Integer>[] A;  //ArrayList 타입의 배열
    static boolean arrive;
    public static void main(String[] args) {
        int N;
        int M;
        arrive = true;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N];
        for (int i=0; i<N; i++)
            A[i] = new ArrayList<Integer>();

        for (int i=0; i<M; i++) {   //인접 리스트에 그래프 데이터 저장
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        DFS(1,1);
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static void DFS(int now, int depth){
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int next : A[now]){
            if(!visited[next])
                DFS(next, depth + 1);
        }
        visited[now] = false;
    }
}