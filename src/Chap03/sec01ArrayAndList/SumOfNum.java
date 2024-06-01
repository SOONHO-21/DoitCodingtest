package Chap03.sec01ArrayAndList;

import java.util.Scanner;

public class SumOfNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i<times; i++) {
            sum = cNum[i] - '0';
        }
        System.out.println(sum);
    }
}