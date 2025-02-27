import java.util.*;
import java.io.*;

public class Main {
    static int n, answer;
    static int[] arr, visit;
    static StringBuilder sb = new StringBuilder();
    
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void count(int start, int now) {
        answer--;
        if (start != now) count(start, arr[now]);
    }

    static void find(int v, int now) {
        if (visit[now] == v) {
            count(now, arr[now]);
        } else if (visit[now] == 0) {
            visit[now] = v;
            find(v, arr[now]);
        }
    }

    public static void main(String[] args) throws IOException {

        int T = read();
        for (int t = 0; t < T; t++) {
            n = read();
            arr = new int[n+1];
            visit = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = read();
            }
            answer = n;
            for (int i = 1; i <= n; i++) {
                find(i, i);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}

