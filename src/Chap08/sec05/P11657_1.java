package Chap08.sec05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_1 {
    static int N, M;
    static Edge_1[] edge_1s;
    static int[] distance;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edge_1s = new Edge_1[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edge_1s[i] = new Edge_1(start, end, value);
        }
        distance[1] = 0;
        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                Edge_1 edge1 = edge_1s[j];
                if(distance[edge1.start] != Integer.MAX_VALUE &&
                        distance[edge1.end] > distance[edge1.start] + edge1.value){
                    distance[edge1.end] = distance[edge1.start] + edge1.value;
                }
            }
        }
        boolean mCycle = false;
        for(int i=0; i<M; i++){
            Edge_1 edge1 = edge_1s[i];
            if(distance[edge1.start] != Integer.MAX_VALUE &&
                    distance[edge1.end] > distance[edge1.start] + edge1.value) {
                mCycle = true;
            }
        }
        if(!mCycle){
            for(int i=2; i<=N; i++){
                if(distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else {
            System.out.println("-1");
        }
    }
}
class Edge_1 {
    int start;
    int end;
    int value;
    public Edge_1(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}