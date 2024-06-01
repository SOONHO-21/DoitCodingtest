package Chap05.sec01DFS;


import java.sql.Array;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.EventListener;
=======
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
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
<<<<<<< HEAD
        DFS(1,1);
=======
        for (int i=0; i<N; i++) {
            DFS(i, 1);  //노드 값 0, depth 1부터 시작
            if(arrive)
                break;
        }
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
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
<<<<<<< HEAD
        for(int next : A[now]){
            if(!visited[next])
                DFS(next, depth + 1);
=======
        for (int i : A[now]){   //향상된 for문으로 각 ArrayList에 있는 요소들 방문여부 체크
            if(!visited[now])   //i라는 노드를 아직 방문한 적이 없으면?
                DFS(now, i+1);
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
        }
        visited[now] = false;
    }
}