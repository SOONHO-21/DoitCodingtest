package Chap05.sec02BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_1 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, M;
    static int[][] A;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }
    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<N; i++){
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];
                if(mx >= 0 && my >= 0 && mx < N && my < M) {    //유효한 좌표인가?
                    if(A[mx][my] != 0 && !visited[mx][my]){ //이동 가능하고 방문한 적이 없는 좌표인가?
                        visited[mx][my] = true;
                        A[mx][my]++;
                        queue.add(new int[] {mx, my});
                    }
                }
            }
        }
    }
}