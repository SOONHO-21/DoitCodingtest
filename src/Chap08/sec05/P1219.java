package Chap08.sec05;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1219 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static long[] distance, cityMoney;
    private static Edge_2[] edges;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge_2[N];
        distance = new long[N];     //교통비 배열
        cityMoney = new long[N];    //벌이 배열
        Arrays.fill(distance, Long.MIN_VALUE);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge_2(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cityMoney[i] = Integer.parseInt(st.nextToken());
        }
        //밸만 포드 수행
        distance[startCity] = cityMoney[startCity];
        for(int i=0; i<N+100; i++){
            for(int j=0; j<M; j++){
                Edge_2 edge = edges[j];
                if(distance[edge.start] == Long.MIN_VALUE) continue;
                else if (distance[edge.start] == Long.MAX_VALUE)
                    distance[edge.end] = Long.MAX_VALUE;
                else if(distance[edge.end] < distance[edge.start] + cityMoney[edge.end] - edge.price) {
                    distance[edge.end] = distance[edge.start] + cityMoney[edge.end] - edge.price;
                    if(i >= N-1)    //양수 사이클 처리. 무한대로 돈을 벌 수 있을 때
                        distance[edge.end] = Long.MAX_VALUE;
                }
            }
        }
        if(distance[endCity] == Long.MIN_VALUE) System.out.println("gg");   //도착 불가
        else if (distance[endCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[endCity]);
    }
}
class Edge_2 {
    int start, end, price;
    public Edge_2(int start, int end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }
}