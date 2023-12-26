package Chap04.sec01BubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        for (int i=0; i<N; i++) {   //배열 A[] 초기화
            A[i] = new mData(Integer.parseInt(br.readLine()), i);   //배열의 값과 인덱스
        }

        Arrays.sort(A); //배열 정렬

        int Max = 0;
        for(int i=0; i<N; i++) {
            if(Max < A[i].index - i)
                Max = A[i].index - i;
        }
        System.out.println(Max + 1);    //swap이 일어나지 않는 반복문이 한번 더 실행되니 +1 시킴
    }
}

class mData implements Comparable<mData> {
    int index;
    int value;

    public mData(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;    //음수면 오름차순 정렬
    }
}