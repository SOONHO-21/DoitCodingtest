package Chap08.sec07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414 {
    static int[] parent;    //대표 노드 배열
    static PriorityQueue<IEdge> queue;
    static int N, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new PriorityQueue<>();
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for(int j=0; j<N; j++){
                int temp = 0;
                if(tempc[j]>='a' && tempc[j]<='z')
                    temp = tempc[j] - 'a' + 1;
                else if(tempc[j]>='A' && tempc[j]<='Z')
                    temp = tempc[j] - 'A' + 27;
                if(i!=j && temp!=0) queue.add(new IEdge(i, j, temp));
            }
        }
        parent = new int[N];
        for(int i=0; i<parent.length; i++) parent[i] = i;
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()){
            IEdge now = queue.poll();
            if(now.s != now.e){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }
        if(useEdge == N-1) System.out.println(sum - result);
        else System.out.println(-1);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;  //대표 노드 설정
    }
    public static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}
class IEdge implements Comparable<IEdge>{
    int s, e, v;
    public IEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(IEdge o) {
        return this.v - o.v;
    }
}
