package Chap08.sec07;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1197 {
    static int[] parent;    //대표 노드 배열
    static PriorityQueue<pEdge> queue;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        queue = new PriorityQueue<>();
        parent = new int[N+1];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }
        int useEdge = 0;    //에지 사용 횟수
        int result = 0;     //결과값
        while (queue.isEmpty()){
            pEdge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                useEdge++;
                result = result + now.v;
            }
        }
        System.out.println(result);
    }
    public static void union(int a, int b){     //유니온 연산
        a = find(a);
        b = find(b);
        if(a!=b)
            parent[b] = a;
    }
    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);  //경로 압축 부분. 대표 노드값 저장
    }
}
class pEdge implements Comparable<pEdge>{
    int s;
    int e;
    int v;
    public pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(pEdge o) {
        return this.v - o.v;
    }
}