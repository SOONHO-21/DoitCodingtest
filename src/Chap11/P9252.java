package Chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9252 {
    static long[][] DP;
    static char[] A;
    static char[] B;
    static ArrayList<Character> Path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();    //첫 번째 문자열
        B = br.readLine().toCharArray();    //두 번째 문자열
        DP = new long[A.length+1][B.length+1];
        Path = new ArrayList<Character>();
        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1] == B[j-1])
                    DP[i][j] = DP[i-1][j-1] + 1;
                else
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j+1]);
            }
        }
        System.out.println(DP[A.length][B.length]);
        getText(A.length, B.length);    //공통 문자열 만들기
        for(int i=Path.size()-1; i>=0; i--)
            System.out.print(Path.get(i));
    }
    private static void getText(int r, int c){
        if(r==0 || c==0) return;
        if(A[r-1]==B[c-1]){     //같은 인덱스에 문자가 같으면
            Path.add(A[r-1]);   //Path에 문자 추가
            getText(r-1, c-1);  //DP[][] 배열의 왼쪽 위 대각선으로 이동
        } else {        //A, B가 다르다면
            if(DP[r-1][c] > DP[r][c-1])     //왼쪽 값과 위 값 중 더 큰 쪽으로 이동
                getText(r-1, c);
            else
                getText(r, c-1);
        }
    }
}