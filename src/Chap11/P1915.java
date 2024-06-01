package Chap11;

import java.util.Scanner;

public class P1915 {
    public static void main(String[] args) {
        long[][] D = new long[1001][1001];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long max = 0;
        for(int i=1; i<=N; i++){
            String mline = sc.next();
            for(int j=1; j<=M; j++){
                D[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
                if(D[i][j] > 0 && i>0 && j>0)
                    D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + D[i][j];
                if(max < D[i][j])
                    max = D[i][j];
            }
        }
        System.out.println(max * max);
    }
}