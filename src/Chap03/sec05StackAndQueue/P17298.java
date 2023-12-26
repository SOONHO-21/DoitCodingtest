package Chap03.sec05StackAndQueue;

import java.io.*;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int A[] = new int[N];
        int result[] = new int[N];
        String[] str = bf.readLine().split(" ");
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(str[i]);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i<N; i++){
            //스택이 아직 안 비어있고, 스택의 맨 위의 값이 A[i]보다 작으면 정답 배열에 A[i]를 대입한다
            while (!stack.isEmpty() && A[stack.peek()] < A[i]){
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++)
            bw.write(result[i]);
        bw.write("\n");
        bw.flush();
    }
}
