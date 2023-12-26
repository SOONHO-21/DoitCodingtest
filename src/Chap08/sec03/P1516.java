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
        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1];
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

        for(int i=1; i<=N; i++){
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}