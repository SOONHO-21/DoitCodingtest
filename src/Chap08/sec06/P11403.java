package Chap08.sec06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] distance;
    static int N;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        distance = new int[N][N];

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N; j++){
                int v = Integer.parseInt(st.nextToken());
                distance[i][j] = v;
            }
        }
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(distance[i][k] == 1 && distance[k][j] == 1) distance[i][j] = 1;
                }
            }
        }
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(distance[i][j]);
            }
            System.out.println();
        }
    }
}