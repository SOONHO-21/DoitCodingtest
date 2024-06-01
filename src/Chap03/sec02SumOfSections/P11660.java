package Chap03.sec02SumOfSections;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //배열 크기
        int M = Integer.parseInt(st.nextToken());  //합을 구해야하는 횟수(질의의 횟수)
        int[][] A = new int[N + 1][N + 1];    //인덱스를 1부터 해야되기 때문에. 둘 중 하나가 0이면 0이다.
        int[][] D = new int[N + 1][N + 1];     //마찬가지
        //A 초기화
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //구간 합 dp 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i][j] + A[i][j];
            }
        }
        //질의의 개수 만큼 구간 합 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = D[x2][y2] - D[x1 - 1][y1] - D[x1][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}