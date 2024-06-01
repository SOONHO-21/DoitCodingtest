package Chap10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722 {
    public static void main(String[] args) throws IOException {
        int N, Q;
        long[] F = new long[21];
        int[] S = new int[21];
        boolean[] visited = new boolean[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        F[0] = 1;
        for(int i=1; i<=N; i++){
            F[i] = F[i-1] * i;
        }
        if(Q==1){
            long K = Integer.parseInt(st.nextToken());
            for(int i=0; i<N; i++){
                for(int j=1; j<N; j++){
                    if(visited[j])
                        continue;
                    if(F[N-i-1] < K)
                        K -= F[N-i-1];
                    else {
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
                System.out.println(S[i]);
            }
        } else {
            long K = 1;
            for(int i=0; i<N; i++){
                S[i] = Integer.parseInt(st.nextToken());
                for(int j = 1; j < S[i]; j++){
                    if(visited[j] == false)
                        K += F[N-i-1];
                }
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
    }
}