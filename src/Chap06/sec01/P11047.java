package Chap06.sec01;

import java.util.Scanner;

public class P11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Target = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        int count = 0;
        for(int i=N-1; i>=0; i--){
            if(A[i]<Target){
                count += (Target / A[i]);
                Target = Target % A[i];
            }
        }
        System.out.println(count);
    }
}