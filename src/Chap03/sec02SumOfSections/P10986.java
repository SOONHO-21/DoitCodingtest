package Chap03.sec02SumOfSections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());  // A 배열 크기
        int M = Integer.parseInt(stringTokenizer.nextToken());  // 나눌 수
        int[] S = new int[N+1];
        int[] C = new int[M];
        int result = 0;

        //합 배열 S[] 초기화
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=1; i<N+1; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        int remainer;
        //합 배열 S[]의 요소들을 M으로 나누기해서 C[] 초기화
        for (int i=1; i<N+1; i++) {
            remainer = S[i] % M;
            if(remainer == 0)
                result++;
            C[remainer]++;
        }
        for (int i=1; i<C.length; i++) {
            result += C[i]*(C[i]-1)/2;
        }
        System.out.println(result);
    }
}