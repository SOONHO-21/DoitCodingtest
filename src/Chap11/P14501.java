package Chap11;

import java.util.Scanner;

public class P14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] D = new int[N+2];
        for(int i=1; i<=N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for(int i=N; i>=1; i--){    //탑다운 방식으로 해결
            if(i+T[i]>N+1){
                D[i] = D[i+1];
            } else {
                D[i] = Math.max(D[i+1], D[i + T[i]] + P[i]);
            }
        }
        System.out.println(D[1]);
    }
}