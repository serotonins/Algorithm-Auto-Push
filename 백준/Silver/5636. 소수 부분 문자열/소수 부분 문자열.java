import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] sosu = new boolean[100001];
        Arrays.fill(sosu, true);
        sosu[0] = sosu[1] = false;
        for (int i = 2; i < Math.sqrt(100000) + 1; i++) {
            if (!sosu[i]) continue;
            for (int j = i * i; j < 100001; j += i) {
                sosu[j] = false;
            }
        }

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;
            int start = 100000;
            int answer = 0;
            if (s.length() < 6) {
                start = Integer.parseInt(s);
            }

            for (int i = start; i > 1; i--) {
                if (sosu[i] && s.contains(i + "")) {
                    answer = i;
                    break;
                }
            }
            bw.append(answer+"\n");
        }

        bw.flush();
        bw.close();
    }
}

