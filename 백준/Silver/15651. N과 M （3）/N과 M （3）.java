import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void back(int p) throws IOException {
        if (p == m) {
            for (int i = 0; i < m; i++) {
                bw.append(arr[i] + " ");
            }
            bw.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[p] = i;
            back(p+1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        back(0);


        bw.flush();
        bw.close();

    }
}

