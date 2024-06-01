package Chap05.sec03BinarySearch;

import java.util.Scanner;

public class P2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N + 1];
        for (int i = 1; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int start = 0;
        int end = 0;
        for(int i=1; i<=N; i++){
            if(start < A[i]) start = A[i];
            end += A[i];
        }
        while (start <= end){
            int middle = (int) (start + end)/2;
            int sum = 0;
            int count = 0;
            for(int i=1; i<=N; i++){
                if(middle <= sum){
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            if(sum != 0)
                count++;
            if(count > M)
                start = middle + 1;
            else
                end = middle - 1;
        }
        System.out.println(start);
    }
}