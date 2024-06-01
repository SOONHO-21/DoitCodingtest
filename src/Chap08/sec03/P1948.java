package Chap08.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> A = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<dNode>());
            reverseA.add(new ArrayList<dNode>());
        }
        int[] indegree = new int[N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            A.get(S).add(new dNode(E, V));
            reverseA.get(E).add(new dNode(S, V));
            indegree[E]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(br.readLine());
        int endCity = Integer.parseInt(br.readLine());
        //위상 정렬
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(startCity);
//        int[] result = new int[N+1];    //경로 배열
//        while (!queue.isEmpty()) {
//            int now = queue.poll();     //출발하는 현재 노드
//            for(dNode d : A.get(now)){
//                indegree[d.targetNode]--;
//                result[d.targetNode] = Math.max(result[d.targetNode],
//                        result[now] + d.time);
//                if(indegree[d.targetNode] == 0)
//                    queue.offer(d.targetNode);
//            }
//        }
        //역위상 정렬
//        boolean[] vistited = new boolean[N+1];
//        int resultCount = 0;
//        queue = new LinkedList<>();
//        queue.offer(endCity);
//        vistited[endCity] = true;
//        while (!queue.isEmpty()){
//            int now = queue.poll();
//            for(dNode d : reverseA.get(now)){
//                if(result[d.targetNode] + d.time == result[now]){
//                    resultCount++;
//                    if(vistited[d.targetNode] == false) {
//                        vistited[d.targetNode] = true;
//                        queue.offer(d.targetNode);
//                    }
//                }
//            }
//        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        int[] result = new int[N+1];
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(dNode next : A.get(now)){
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode],
                        result[now] + next.time);
                if(indegree[next.targetNode] == 0){
                    queue.offer(next.targetNode);
                }
            }
        }
        queue = new LinkedList<>();
        queue.offer(endCity);
        boolean[] visited = new boolean[N+1];
        int resultCount = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(dNode next : reverseA.get(now)){
                if(result[next.targetNode] + next.time == result[now]){
                    resultCount++;
                    if(visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[endCity]);
        System.out.println(resultCount);
    }
}
class dNode {
    int targetNode;
    int time;
    public dNode(int targetNode, int time) {
        this.targetNode = targetNode;
        this.time = time;
    }
}