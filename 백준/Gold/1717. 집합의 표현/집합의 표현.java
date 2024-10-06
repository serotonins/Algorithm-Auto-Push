import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;

    public static int find(int x) {
        if (x == arr[x]) {return x;}
        arr[x] = find(arr[x]);
        return arr[x];
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {arr[y] = x;}
        else {arr[x] = y;}
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = i;
        }

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int inst = Integer.parseInt(st.nextToken());
            if (inst == 0) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                boolean isFamily = find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()));
                bw.append((isFamily? "YES": "NO") + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}

