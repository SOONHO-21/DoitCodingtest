package Chap11;

import java.util.Scanner;

public class P1328 {
    static int mod = 10000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int[][][] D = new int[N+1][L+1][R+1];
        D[1][1][1] = 1;
        for(int i=2; i<=N; i++){
            for(int j=1; j<=L; j++){
                for(int k=1; k<=R; k++){
                    D[i][j][k] = (D[i-1][j][k-1] + D[i-1][j-1][k] + D[i-1][j][k] * (i-2)) % mod;
                }
            }
        }
        System.out.println(D[N][L][R]);
    }
}