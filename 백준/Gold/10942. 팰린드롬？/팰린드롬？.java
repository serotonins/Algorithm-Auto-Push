import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, answer, len, inf = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {

        n = read();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }
        m = read();
        for (int t = 0; t < m; t++) {
            int s = read();
            int e = read();
            boolean pal = true;
            for (int i = 0; i < (e-s+1)/2; i++) {
                if (arr[s+i] != arr[e-i]) {
                    pal = false;
                    break;
                }
            }
            sb.append(pal ? 1 : 0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

