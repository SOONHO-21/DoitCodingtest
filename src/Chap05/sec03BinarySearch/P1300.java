package Chap05.sec03BinarySearch;

import java.util.Scanner;

public class P1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
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
            }
        }
        System.out.println(result);
    }
}