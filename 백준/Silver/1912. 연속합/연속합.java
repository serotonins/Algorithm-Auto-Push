import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] minis = new int[n];
        int answer = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            minis[i] = Math.min(arr[i], 0);
            if (i!=0) {
                arr[i] += arr[i - 1];
                minis[i] = Math.min(arr[i], minis[i-1]);
            }
        }

//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < n; i++) {
            if (i == 0) answer = Math.max(answer, arr[i]);
            else answer = Math.max(answer, arr[i]-minis[i-1]);
        }

        System.out.println(answer);
    }
}

