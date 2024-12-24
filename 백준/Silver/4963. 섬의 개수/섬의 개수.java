import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[][] area;
    static int[][] dr = {{0,1,0,-1, 1,1,-1,-1}, {1,0,-1,0, 1,-1,1,-1}};
    static boolean isOut(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= m;
    }

    static void dfs(int y, int x) {
        area[y][x] = false;
        for (int d = 0; d < 8; d++) {
            int w = y + dr[0][d];
            int v = x + dr[1][d];
            if (!isOut(w,v) && area[w][v]) {
                dfs(w,v);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (m == n && n == 0) {break;}

            area = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    area[i][j] = st.nextToken().equals("1");
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (area[i][j]) {
                        dfs(i,j);
                        answer++;
                    }
                }
            }

            sb.append(answer+"\n");
        }

        System.out.println(sb.toString());
    }
}

