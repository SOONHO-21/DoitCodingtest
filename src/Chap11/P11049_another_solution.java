package Chap11;

import java.io.IOException;
import java.security.spec.NamedParameterSpec;
import java.util.Scanner;

public class P11049_another_solution {
    static int N;
    static int[][] D;
    static int[][] M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N+1][N+1];
        M = new int[N+1][2];
        for(int i=1; i<=N; i++){
            M[i][0] = sc.nextInt();
            M[i][1] = sc.nextInt();
        }
        System.out.println(excute(1, N));
    }
    static int excute(int s, int e){
        for(int i=1; i<N; i++){
            D[i][i+1] = M[i][0] * M[i][1] * M[i+1][1];
        }
        for(int gap=2; gap<=N; gap++){
            for(int i=1; i<=(N-gap+1); i++){
                int j = i+gap;
                for(int k=1; k<j; k++){
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k+1][j] + (M[i][0] * M[k][1] * M[j][1]));
                }
            }
        }
        int min = D[1][N];
        return min;
    }
}