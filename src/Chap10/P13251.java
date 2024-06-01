package Chap10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13251 {
    static int T, M, K;
    static double probability[];
    static int D[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        D = new int[51];
        int T=0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            T += D[i];
        }
        K = Integer.parseInt(st.nextToken());
        probability = new double[51];
        int result = 0;
        for(int i=0; i<M; i++){
            probability[i] = 1.0;
            for(int k=0; k<K; k++){
                probability[i] *= (double)(D[i]-i) / (double)(T-i);
            }
            result += probability[i];
        }
        System.out.println(result);
    }
}