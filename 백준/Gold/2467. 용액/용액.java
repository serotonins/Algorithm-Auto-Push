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
        int[] answer = new int[2];
        while (start < end && end < n) {
            int diff = fluid[end] + fluid[start];
            int abs_diff = Math.abs(diff);
            if (abs_diff < mini) {
                mini = abs_diff;
                answer[0] = fluid[start];
                answer[1] = fluid[end];
            }
            if (diff < 0) start++;
            else if (diff > 0) end--;
            else break;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}

