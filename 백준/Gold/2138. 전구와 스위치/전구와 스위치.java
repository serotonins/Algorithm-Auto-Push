import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, m, inf = Integer.MAX_VALUE;
    static boolean[] originZero, originOne, want;


    static StringBuilder sb = new StringBuilder();
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        String originStr = br.readLine();
        String wantStr = br.readLine();
        originZero = new boolean[n];
        originOne = new boolean[n];
        want = new boolean[n];
        for (int i = 0; i < n; i++) {
            originZero[i] = originStr.charAt(i) == '1';
            originOne[i] = originStr.charAt(i) == '1';
            want[i] = wantStr.charAt(i) == '1';
        }

        int zero = 0;
        int one = 1;
        originOne[0] ^= true;
        originOne[1] ^= true;
        for (int i = 1; i < n-1; i++) {
            if (originZero[i-1] != want[i-1]) {
                zero++;
                originZero[i-1] ^= true;
                originZero[i] ^= true;
                originZero[i+1] ^= true;
            }
            if (originOne[i-1] != want[i-1]) {
                one++;
                originOne[i-1] ^= true;
                originOne[i] ^= true;
                originOne[i+1] ^= true;
            }
        }

        if (originZero[n-2] != want[n-2]) {
            zero++;
            originZero[n-2] ^= true;
            originZero[n-1] ^= true;
        }
        if (originZero[n-1] != want[n-1]) zero = inf;
        if (originOne[n-2] != want[n-2]) {
            one++;
            originOne[n-2] ^= true;
            originOne[n-1] ^= true;
        }
        if (originOne[n-1] != want[n-1]) one = inf;

        int answer = Math.min(zero, one);
        if (answer == inf) answer = -1;
        System.out.println(answer);
    }
}