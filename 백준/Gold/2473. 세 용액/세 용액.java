import java.util.*;
import java.io.*;

public class Main {
    static int n;

    static int bin(int now, int start, int[] arr) {
        int s = start;
        int e = arr.length-1;
        int p = (s+e)/2;
        while (s <= e && e < arr.length) {
            p = (s+e)/2;
            long temp = (long) now + arr[p];
            if (temp < 0) s = p+1;
            else if (temp > 0) e = p-1;
            else return p;
        }

        if (e == start-1) e++;
        if (s == arr.length) s--;
        if (Math.abs((long) now + arr[s]) < Math.abs((long) now + arr[e])) return s;
        return e;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[n];
        int idx = 0;
        for (int i : set) {
            arr[idx++] = i;
        }

        long sum = 3_000_000_000L;
        int[] answer = new int[3];
        for (int i = 0; i <= n-3; i++) {
            for (int j = i+1; j <= n-2; j++) {
                int p = bin(arr[i]+arr[j], j+1, arr);
                long temp = Math.abs((long) arr[i]+arr[j]+arr[p]);
                if (temp < sum) {
                    sum = temp;
                    answer[0] = arr[i];
                    answer[1] = arr[j];
                    answer[2] = arr[p];
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i]);
            System.out.print(" ");
        }
    }
}

