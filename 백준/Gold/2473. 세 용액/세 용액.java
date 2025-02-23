import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        int[] answer = new int[3];
        if (arr[0] >= 0) {
            for (int i = 0; i < 3; i++) {
                answer[i] = arr[i];
            }
        } else if (arr[n-1] <= 0) {
            for (int i = 0; i < 3; i++) {
                answer[i] = arr[n-3+i];
            }
        } else {
            long sum = 3_000_000_000L;
            int two, thr;
            for (int one = 0; one <= n-3; one++) {
                two = one+1;
                thr = n-1;

                while (two < thr) {
                    long temp = (long) arr[one] + arr[two] + arr[thr];
                    if (sum > Math.abs(temp)) {
                        sum = Math.abs(temp);
                        answer[0] = arr[one];
                        answer[1] = arr[two];
                        answer[2] = arr[thr];
                    }
                    if (temp == 0) break;
                    else if (temp > 0) thr--;
                    else two++;
                }


            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i]);
            System.out.print(" ");
        }
    }
}

