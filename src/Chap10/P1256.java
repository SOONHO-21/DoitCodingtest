package Chap10;

import java.util.Scanner;

public class P1256 {
    static int N, M, K;
    static int[][] D;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        D = new int[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i || j == 0) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                    if(K > 1000000000) D[i][j] = 1000000001;
                }
            }
        }
        if(D[N+M][M] < K){
            System.out.println("-1");
        } else {
            while (!(N==0 && M==0)){
                int T = D[N-1+M][M];
                if(T >= K){
                    System.out.print('a');
                    N--;
                } else {
                    System.out.print('z');
                    K = K - D[N-1+M][M];
                    M--;
                }
            }
        }
    }
}