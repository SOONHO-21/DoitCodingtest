package Chap03.sec04SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891 {
    static int myArr[];
    static int[] checkArr;
    static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        myArr = new int[4];     //A, C, G, T의 개수를 담는 배열
        checkArr = new int[4];  //필요한 A, C, G, T의 개수를 설정하는 배열
        int Result = 0;

        char A[];
        checkSecret = 0;

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); //체크 배열 초기화
            if(checkArr[i] == 0){   //A, G, C, T 중 뭔가가 필요한 개수가 0이면
                checkSecret++;  //해당 문자가 이미 있을 필요가 없으니까. 개수가 4에 가까워 지도록
            }
        }
        for (int i=0; i<P; i++) {   //부분 문자열 최초로 받을 때 세팅. 부분 문자열 만큼 0부터 체크
            Add(A[i]);      //A[]의 현재 첫 번째 값을 더하기
        }

        if(checkSecret == 4) Result++;
        //여기 까지가 최초의 부분 배열 부분 해결

        //슬라이딩 윈도우 알고리즘
        for(int i=P; i<S; i++) {
            int j = i-P;    //i: 다음 슬라이드의 맨 오른쪽(추가), j: 이전 슬라이드의 맨 왼쪽(제거)
            Add(A[i]);      //오른쪽에 다음 마지막 요소 추가
            Remove(A[j]);   //왼쪽에 있던 이전 첫번째 요소 제거
            if(checkSecret == 4) Result++;
        }
        System.out.println(Result);
        bf.close();
    }
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}