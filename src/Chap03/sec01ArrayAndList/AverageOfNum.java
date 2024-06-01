package Chap03.sec01ArrayAndList;

import java.util.Scanner;

public class AverageOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subNum = sc.nextInt();
        int[] score = new int[subNum];
        int scoreSum = 0;
        int max = 0;
        for (int i=0; i<subNum; i++){
            score[i] = sc.nextInt();
            if(score[i] > max)
                max = score[i];
            scoreSum += score[i];
        }
        System.out.println((double) ((scoreSum*100)/max)/subNum);
    }
}