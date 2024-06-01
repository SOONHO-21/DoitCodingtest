package Chap08.sec01;

import java.util.*;

public class P18352 {
    static int visited[];
    static ArrayList<Integer>[] A;
    static int N, M, K , X;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //도시(노드) 수
        M = sc.nextInt();   //도로(에지) 수
        K = sc.nextInt();   //목표 거리
        X = sc.nextInt();   //시작점
        A = new ArrayList[N+1];
        answer = new ArrayList<>();

        for(int i=0; i<N; i++)      //도시 개수만큼 ArrayList 초기화
            A[i] = new ArrayList<Integer>();
        for(int i=0; i<M; i++){     //도로 개수만큼 초기화 하기
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }
        visited = new int[N+1];
        for(int i=0; i<=N; i++){
            visited[i] = -1;
        }

        BFS(X);     //시작점 X로부터 탐색

        for(int i=0; i<=N; i++){
            if(visited[i] == K)
                answer.add(i);
        }
        if(answer.isEmpty()) {
            System.out.println(-1);
        }
        else {
            Collections.sort(answer);   //answer를 오름차순 정렬
            for(int temp : answer)
                System.out.println(temp);
        }
    }

    private static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;    //방문 횟수 증가
        while (!queue.isEmpty()){
            int new_Node = queue.poll();
            for(int i : A[new_Node]){   //새로운 노드를 탐색
                if(visited[i] == -1) {
                    visited[i] = visited[new_Node] + 1; //방문 거리가 new_Node로부터 +1 떨어져 있다
                    queue.add(i);
                }
            }
        }
    }
}