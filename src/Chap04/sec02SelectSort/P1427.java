package Chap04.sec02SelectSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];

        for(int i=0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for(int i=0; i < str.length(); i++) {
            int MAX = i;
            for(int j=i+1; j<str.length(); j++) {
                if(A[MAX] < A[j])
                    MAX = j;
            }
            if(A[i] < A[MAX]) {
                int temp = A[i];
                A[i] = A[MAX];
                A[MAX] = temp;
            }
        }

        System.out.println(Arrays.toString(A));
    }
}