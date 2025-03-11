import java.util.*;
import java.io.*;

public class Main {
    static int n, answer;
    static int[][] arr, visit;

    static int[][] dr = {{0,0,-1,1}, {1,-1,0,0}};
    static boolean isOut(int y, int x) {return y < 0 || y >= n || x < 0 || x >= n;}

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static int back(int y, int x) {
        /*
        갈 수 있는 곳으로 간다 | 더 이상 갈 수 없으면 현재 칸에 1을 저장하고 반환한다

        미리 와본 곳(visit이 0이 아닌 곳)이면 visit값을 반환한다

        (다음 호출의 반환값 + 1)을 이 칸의 visit에 남긴다
         */
        if (visit[y][x] != 0) return visit[y][x];

        for (int i = 0; i < 4; i++) {
            int w = y + dr[0][i];
            int v = x + dr[1][i];
            if (isOut(w,v) || arr[w][v] <= arr[y][x]) continue;
            visit[y][x] = Math.max(back(w,v), visit[y][x]);
        }

        return ++visit[y][x];
    }

    public static void main(String[] args) throws IOException {
        
        n = read();
        arr = new int[n][n];
        visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = read();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                back(i, j);
                answer = Math.max(answer, visit[i][j]);
            }
        }

        System.out.println(answer);
    }
}

