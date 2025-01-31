import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;

    static int[][] dr = {{0,0,0,-1,1}, {0,1,-1,0,0}};

    static boolean isOut(int y, int x) {return y < 0 || y >= n || x < 0 || x >= m;}

    static int[][] map;

    static class Dice {
        int top = 0, up = 0, right = 0, down = 0, left = 0, bottom = 0;
        int y, x;
        public Dice(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public Dice roll(int d) {
            if (isOut(y+dr[0][d], x+dr[1][d])) return this;

            if (d == 1) east();
            else if (d == 2) west();
            else if (d == 3) north();
            else south();

            if (map[y][x] == 0) map[y][x] = bottom;
            else {
                bottom = map[y][x];
                map[y][x] = 0;
            }

            System.out.println(top);

            return this;
        }

        public void east() {
            int temp = top;
            top = left;
            left = bottom;
            bottom = right;
            right = temp;
            x++;
        }
        public void west() {
            int temp = top;
            top = right;
            right = bottom;
            bottom = left;
            left = temp;
            x--;
        }
        public void north() {
            int temp = top;
            top = down;
            down = bottom;
            bottom = up;
            up = temp;
            y--;
        }
        public void south() {
            int temp = top;
            top = up;
            up = bottom;
            bottom = down;
            down = temp;
            y++;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Dice dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < k; t++) {
            dice.roll(Integer.parseInt(st.nextToken()));
        }
    }
}

