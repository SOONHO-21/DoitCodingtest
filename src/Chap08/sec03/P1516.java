package Chap08.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //건물(노드)의 개수
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<N; i++)
            A.add(new ArrayList<Integer>());
<<<<<<< HEAD
        int[] indegree = new int[N+1];      //진입차수 배열
        int[] selfBuild = new int[N+1];     //건물 짓는데 걸리는 시간(미리 지어야 하는 건물 미포함)
=======
        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1];
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true){
                int pretemp = Integer.parseInt(st.nextToken()); //미리 세워야 하는 건물의 노드
                if(pretemp == -1)   //'미리 세워야 하는 건물의 노드'입력 종료
                    break;
                A.get(pretemp).add(i);  //현재 노드를 미리 세워야 하는 건물의 노드 리스트에 추가
                indegree[i]++;
            }
        }
<<<<<<< HEAD
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        int[] result = new int[N+1];
        while (queue.isEmpty()){
            int now = queue.poll();
            for(int next : A.get(now)){
                result[next] = Math.max(result[next], (result[now] + selfBuild[now]));
                indegree[next]--;
                if(indegree[next] == 0) //먼저 지어야 되는 건물들 다 처리했으면
                    queue.offer(next);  //위상 정렬 배열에 추가
            }
        }
=======
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int result[] = new int[N+1];
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int next : A.get(now)){
                indegree[next]--;
                //시간 업데이트 하기. 현재 노드의 건설시간 +
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if(indegree[next] == 0)
                    queue.offer(next);
            }
        }

>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
        for(int i=1; i<=N; i++){
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}