import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static List<WV> list = new ArrayList<>();
    static boolean ok = false;
    
    static class WV {
        int y, x;
        public WV(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public String toString() {
            return "[" + y + ", " + x + "]";
        }
    }
    static ArrayDeque<WV> que = new ArrayDeque<>();

    static void back(int p) {
        if (p == list.size()) {
            ok = true;
            return;
        }

        WV now = list.get(p);
        for (int i = 1; i < 10 && !ok; i++) {
            boolean nope = true;
            for (int j = 0; j < 9; j++) {
                if (i == arr[now.y][j] || i == arr[j][now.x] || i == arr[now.y/3*3 + j/3][now.x/3*3 + j%3]) {
                    nope = false;
                    break;
                }
            }
            if (nope) {
                arr[now.y][now.x] = i;
                back(p+1);
                if (ok) return;
                arr[now.y][now.x] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    que.add(new WV(i, j));
                }
            }
        }

        list.addAll(que);

        back(0);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.append(arr[i][j] + " ");
            }
            bw.append("\n");
        }

        bw.flush();
        bw.close();

    }
}

