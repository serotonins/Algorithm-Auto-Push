import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = read();
            nge[i] = -1;
        }

        int now = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (now < n) {
            while (!stack.isEmpty() && arr[now] > arr[stack.peek()]) {
                nge[stack.pop()] = arr[now];
            }
            stack.push(now);
            now++;
        }

        for (int i = 0; i < n; i++) {
            sb.append(nge[i] + " ");
        }

        System.out.println(sb.toString());
    }
}

