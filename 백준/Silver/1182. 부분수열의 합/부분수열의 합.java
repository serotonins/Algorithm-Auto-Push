import java.util.*;
import java.io.*;

public class Main {

    static int answer = 0, n, m;
    static int[] arr;

    static void back(int p, int sum) {
        if (p == n) {
            if (sum == m) answer++;
            return;
        }

        back(p+1, sum);
        back(p+1, sum+arr[p]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        back(0, 0);
        if (m == 0) answer--;
        System.out.println(answer);

//        bw.flush();
//        bw.close();

    }
}

