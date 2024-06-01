package Chap08.sec06;

import java.io.*;
import java.util.StringTokenizer;

public class P1389 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] distance;
    static int N,M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=1; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[s][e] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
        int MIN = Integer.MAX_VALUE;
        int result = -1;
        for(int i=1; i<=N; i++) {
            int temp = 0;
            for (int j=1; j<=N; j++) {
                temp = distance[i][j];
            }
            if(MIN > temp) {
                MIN = temp;
                result = i;
            }
        }
        System.out.println(result);
    }
}