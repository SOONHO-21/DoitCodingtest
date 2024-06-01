package Chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for(int i=0; i<N; i++){
            for(int j=0; j<2; j++){
                A[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if(S[1] == E[1])
                    return S[0] - E[0];
                return S[1] - E[1];
            }
        });
        int count = 0;
        int end = A[0][1];
        for(int i=1; i<N; i++){
            if(end <= A[i][0]){
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}