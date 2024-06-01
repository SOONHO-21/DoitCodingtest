package Chap08.sec07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414_1 {
    static int[] parent;
    static int N, sum;
    static PriorityQueue<IIEdge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            char tempc[] = st.nextToken().toCharArray();
            for(int j=0; j<N; j++){
                int temp = 0;
                if(tempc[j] >= 'a' && tempc[j] <= 'z')
                    temp = tempc[j] - 'a' + 1;
                else if (tempc[j] >='A' && tempc[j] <= 'Z')
                    temp = tempc[j] - 'A' + 27;
                sum += temp;    //총 랜선의 길이 저장
                if(i != j && temp != 0) queue.add(new IIEdge(i, j, temp));
            }
        }
        //위상 정렬
        parent = new int[N];
        for(int i=0; i<N; i++) parent[i] = i;
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()){
            IIEdge now = queue.poll();
            if(now.s != now.e){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }
        if (useEdge == N - 1) System.out.println(sum - result);
        else System.out.println(-1);
    }
    static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }
}
class IIEdge implements Comparable<IIEdge> {
    int s, e, v;
    public IIEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(IIEdge o) {
        return this.v - o.v;
    }
}