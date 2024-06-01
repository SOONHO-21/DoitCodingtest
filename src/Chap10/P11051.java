package Chap10;

import java.util.Scanner;

public class P11051 {
    static int N;
    static int K;
    static int[][] D;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            D[i][1] = i;
            D[i][i] = 1;
            D[i][0] = 1;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
                D[i][j] = D[i][j] % 10007;
            }
        }
        System.out.println(D[N][K]);
    }
}