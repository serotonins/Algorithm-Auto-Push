import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][4];
        int[] ab = new int[n*n], cd = new int[n*n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = arr[i][0] + arr[j][1];
                cd[idx++] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        long answer = 0;

        int left = 0, right = n*n-1;
        while (left < n*n && right >= 0) {
            int temp = ab[left] + cd[right];
            if (temp < 0) left++;
            else if (temp > 0) right--;
            else {
                int lc = 1, rc = 1;
                while (left + 1 < n*n && ab[left] == ab[left+1]) {
                    lc++;
                    left++;
                }
                while (right -1 >= 0 && cd[right] == cd[right-1]) {
                    rc++;
                    right--;
                }
                answer += (long) lc * rc;
                left++;
            }
        }

        System.out.println(answer);
    }
}

