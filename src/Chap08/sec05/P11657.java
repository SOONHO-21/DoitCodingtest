package Chap08.sec05;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] distance;
    private static Edge[] edges;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(br.readLine());
            int end = Integer.parseInt(br.readLine());
            int weight = Integer.parseInt(br.readLine());
            edges[i] = new Edge(start, end, weight);
        }
        //밸만 포드 수행
        distance[1] = 0;
        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE &&
                        distance[edge.end] > distance[edge.start] + edge.weight)
                    distance[edge.end] = distance[edge.start] + edge.weight;
            }
        }
        boolean mCycle = false;
        for(int i=0; i<M; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.weight) {
                distance[edge.end] = distance[edge.start] + edge.weight;
                mCycle = true;  //음수 사이클이 존재한다
            }
        }
        for(int i=2; i<=N; i++){
            bw.write(distance[i]);
        }
        if (!mCycle) {  // 음의 cycle이 없는 경우
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else { // 음의 cycle이 있는 경우
            System.out.println("-1");
        }
    }
}
class Edge{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}