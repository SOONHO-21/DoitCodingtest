package Chap09.sec02;

import java.io.*;
import java.util.*;

public class P14425_anothor_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] strings = new String[n];
        for(int i=0; i<n ;i++){
            map.put(br.readLine(), 0);
        }
        int count = 0;
        for(int i=0; i<m ;i++){
            if(map.containsKey(br.readLine())) count++;
        }
        System.out.println(count);
    }
}