import java.util.*;
import java.io.*;

public class Main {

//    static int n, m;
    static int n, m, answer, inf = Integer.MAX_VALUE;
    static int[] arr;

    static int bin(int target, int start) {
        int s = start;
        int e = n-1;
        int p = (s + e) / 2;
        while (s <= e && e < n) {
            p = (s + e) / 2;
            if (arr[p] < target) s = p+1;
            else if (arr[p] > target) e = p-1;
            else return p;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int t = 0; t < n; t++) {
            arr[t] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int cha = arr[n-1] - arr[0];
        int max_distance = cha / --m;

        int s = 1;
        int e = max_distance;
        int d = (s + e) / 2;
        while (s <= e && e <= max_distance) {
            d = (s + e) / 2;

            boolean ok = false;
            int now = arr[0];
            int idx = 0;
            for (int i = 0; i < m; i++) {
                idx = bin(now+d, idx+1);
                if (idx >= n) {break;}
                now = arr[idx];
                if (i == m-1) ok = true;
                if (now + d * (m-i-1) > arr[n-1] || idx + (m-i-1) > n) {break;}
            }

            if (ok) s = d+1;
            else e = d-1;
        }

        System.out.println(e);
    }
}

