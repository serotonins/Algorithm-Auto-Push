import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, answer, len, inf = Integer.MAX_VALUE;
    static int[] paper, arr;

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void remove(int y, int x, int r) {
        int s = (~specify(x, r)) & 1023;
        for (int i = y; i < y+r && i < 10; i++) {
            arr[i] &= s;
        }
    }

    static void refill(int y, int x, int r) {
        int s = specify(x, r);
        for (int i = y; i < y+r && i < 10; i++) {
            arr[i] |= s;
        }
    }

    static int specify(int x, int r) {
        int i = 0;
        for (int j = 0; j < r; j++) {
            i = (i << 1) + 1;
        }
        return i << (10 - x - r);
    }

    static int measure(int y, int x) {
        int r = 5;
        boolean ok = true;
        while (r > 0) {
            for (int i = 0; i < r; i++) {
                if (y+i >= 10 || x+i >= 10) break;
                int s = specify(x, r);
                if ((arr[y+i] & s ^ s) != 0) break;
                if (i == r-1) return r;
            }
            r--;
        }
        return r;
    }

    static int findX(int y) {
        for (int i = 9; i >= 0; i--) {
            if (arr[y] >= (1 << i)) return 9 - i;
        }
        return 9;
    }

    static int[] findFirst() {
        int[] wv = {-1, -1};
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0) {
                wv[0] = i;
                wv[1] = findX(i);
                break;
            }
        }
        return wv;
    }

    static void back(int y, int x, int cnt) {
        if (cnt-1 >= answer) return;
        int r = measure(y, x);
        while (r > 0) {
            if (paper[r] - 1 < 0) {r--; continue;}
            else paper[r]--;
            remove(y,x,r);
            int[] wv = findFirst();
            if (wv[0] == -1) answer = Math.min(answer, cnt+1);
            else back(wv[0], wv[1], cnt+1);
            paper[r]++;
            refill(y,x,r);
            r--;
        }
    }

    public static void main(String[] args) throws IOException {
        
        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i] = (arr[i] << 1) + read();
            }
        }

        paper = new int[6];
        Arrays.fill(paper, 5);
        answer = inf;

        int[] wv = findFirst();
        if (wv[0] != -1) back(wv[0], wv[1], 0);
        else answer = 0;
        if (answer == inf) answer = -1;

        System.out.println(answer);
    }
}

