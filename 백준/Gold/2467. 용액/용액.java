import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] fluid = new int[n];
        for (int i = 0; i < n; i++) {
            fluid[i] = Integer.parseInt(st.nextToken());
        }

        int mini = 2_000_000_000;
        int start = 0;
        int end = n-1;
        while (start < end && end < n) {
            int diff = fluid[end] + fluid[start];
            int abs_diff = Math.abs(diff);
            if (abs_diff < mini) {
                mini = abs_diff;
                sb = new StringBuilder();
                sb.append(fluid[start] + " " + fluid[end]);
            }
            if (diff < 0) start++;
            else if (diff > 0) end--;
            else break;
        }

        System.out.println(sb.toString());
    }
}

