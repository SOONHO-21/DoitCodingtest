package Chap03.sec02SumOfSections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());  //배열 크기
        int M = Integer.parseInt(stringTokenizer.nextToken());  //합을 구해야하는 횟수(질의의 횟수)
        int[][] arr = new int[N+1][N+1];    //인덱스를 1부터 해야되기 때문에. 둘 중 하나가 0이면 0이다.
        int[][] dp = new int[N+1][N+1];     //마찬가지
        int result;
        //arr 초기화
        for(int i=1; i<N+1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1; j<N+1; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        //구간 합 dp 배열 초기화
        for(int i=1; i<N+1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1; j<N+1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
        //질의의 개수 만큼 구간 합 구하기
        for(int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            result = dp[x2][y2] - dp[x2][y1-1]-dp[x1-1][y2] + dp[x1-1][y1-1];
            System.out.println(result);
        }
    }
}