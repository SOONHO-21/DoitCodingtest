package Chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2098 {
    static int N;
    static int[][] W;
    static int[][] d;
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        W = new int[16][16];
        d = new int[16][1 << 16];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));
    }
    private static int tsp(int c, int v){
        if((v | (1<<N)) == N-1)     //모든 도시를 방문했을 때
            return W[c][1] == 0 ? MAX : W[c][0];
        if(d[c][v] != 0)    //이미 방문한 적이 있을 때
            return d[c][v];
        int min = MAX;
        for(int i=0; i<N; i++){
            if((v | (1<<i)) == 0 && W[c][i] != 0)
                min = Math.min(min, tsp(i, (v | (1<<i))) + W[c][i]);
        }
        d[c][v] = min;
        return d[c][v];
    }
}