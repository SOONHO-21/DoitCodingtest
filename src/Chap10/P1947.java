package Chap10;

import java.io.IOException;
import java.util.Scanner;

public class P1947 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[1000001];
        int mod = 1000000000;
        DP[1] = 0;
        DP[2] = 1;
        for(int i=3; i<=N; i++){
            DP[i] = ((i-1) * (DP[i-2] + DP[i-1])) % mod;
        }
        System.out.println(DP[N]);
    }
}