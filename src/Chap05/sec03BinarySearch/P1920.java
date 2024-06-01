package Chap05.sec03BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        System.out.println(A[N/2]);

        int M = sc.nextInt();
        int[] A_must_find = new int[N];
        for (int i=0; i<M; i++){
            A_must_find[i] = sc.nextInt();
        }

        for (int i=0; i<M; i++){
            boolean find = false;
            int num = A_must_find[i];
            int start = 0;
            int end = A.length-1;
            while (start<=end){
                int mid = (end - start)/2;
                if(num < A[mid]){
                    end = mid;
                    mid = (start + end)/2;
                } else if(num > A[mid]){
                    start = mid+1;
                    mid = start + end;
                } else {
                    find = true;
                    break;
                }
            }
            if(find)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}