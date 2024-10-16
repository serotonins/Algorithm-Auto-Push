import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = m-n;
            if (c < 4) {
                bw.append(m-n+"\n");
                continue;
            }
            int answer = 0;
            for (int i = 1; c > 0; i++) {
                if (c > i) {
                    c -= i * 2;
                    answer += 2;
                } else {
                    c -= i;
                    answer++;
                }
            }
            bw.append(answer + "\n");
        }

        bw.flush();
        bw.close();

    }
}

