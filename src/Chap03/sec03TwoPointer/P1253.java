package Chap03.sec03TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        long[] A = new long[N];
        int Result = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());   //배열 초기화
        }

        Arrays.sort(A);     //입력 초기화한 배열 정렬

        for(int k=0; k<N; k++) {
            long find = A[k];
            int i = 0, j = k-1;
            while (i<j) {
                // i와 j를 한번 더 체크해주는 이유는
                // 자기 자신을 더해서 좋은수의 개수가 +1이 되지 않게 하기 위해서
                if(A[i] + A[j] == find) {
                    if(i != k && j !=k){
                        Result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {    //A[i] + A[j] < find
                    j--;
                }
            }
        }
        System.out.println(Result);
        bufferedReader.close();
    }
}