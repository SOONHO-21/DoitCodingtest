package Chap05.sec03BinarySearch;

import java.util.Scanner;

public class P1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
<<<<<<< HEAD
        int K = sc.nextInt();
        long start = 1;
        long end = K;
        long result = 0;
        while (start <= end){
            long middle = (start + end) / 2;
            long cnt = 0;
            for(int i=1; i<=N; i++){
                cnt += Math.min(middle/i, N);
            }
            if(cnt < K)
                start = middle + 1;
            else {
                result = middle;
                end = middle - 1;
=======
        int k = sc.nextInt();

        int start = 1;
        int end = k;
        int result = 0;
        while (start <= end) {
            int middle = (start + end)/2;
            int cnt = 0;
            for(int i=1; i<=N; i++){
                cnt += Math.min(middle/i, N);
            }
            if(cnt < k){
                start = middle + 1;
            } else {
                end = middle - 1;
                result = middle;
>>>>>>> 8f220557d47ec87b4accc78476f30189aa496f72
            }
        }
        System.out.println(result);
    }
}