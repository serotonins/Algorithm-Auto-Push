import java.util.*;
import java.io.*;

public class Main {

//    static int n, m;
    static int n, s, answer, inf = Integer.MAX_VALUE;
    static int[] sequence, partialSum;
//    static int[][] dr = {{-1,0,1,0}, {0,1,0,-1}};
//
//    static boolean isOut(int y, int x) {
//        return y < 0 || y >= n || x < 0 || x >= m;
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        sequence = new int[n];
        partialSum = new int[n];
        st = new StringTokenizer(br.readLine());
        answer = inf;
        sequence[0] = Integer.parseInt(st.nextToken());
        if (sequence[0] >= s) answer = 1;
        partialSum[0] = sequence[0];

        for (int i = 1; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            if (sequence[i] >= s) {
                answer = 1;
                break;
            }
            partialSum[i] = partialSum[i-1] + sequence[i];
        }

        int start = -1;
        int end = 1;
        while (start <= end && end < n) {
            int minus = 0;
            if (start != -1) minus = partialSum[start];
            int now = partialSum[end] - minus;
            if (now > s) {
                answer = Math.min(answer, end-start);
                start++;
            } else if (now <= s) {
                if (now == s) {answer = Math.min(answer, end-start);}
                end++;
                if (end-start >= answer) start = end-answer+1;
            }
        }

        System.out.println(answer == inf ? 0 : answer);

    }
}

