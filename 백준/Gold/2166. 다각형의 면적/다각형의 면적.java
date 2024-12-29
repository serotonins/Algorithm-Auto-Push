import java.util.*;
import java.io.*;

public class Main {
    static int n, k, inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int[] pre = new int[2];
        int[] last = new int[2];
        st = new StringTokenizer(br.readLine());
        pre[0] = last[0] = Integer.parseInt(st.nextToken());
        pre[1] = last[1] = Integer.parseInt(st.nextToken());

        long answer = 0;
        long two = 0;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            answer += (1l * pre[0] * x - 1l * pre[1] * y);
            pre[0] = y;
            pre[1] = x;
        }
        answer += (1l * pre[0] * last[1] - 1l * pre[1] * last[0]);
        System.out.printf("%.1f", ((double) Math.abs(answer))/2);


    }
}

