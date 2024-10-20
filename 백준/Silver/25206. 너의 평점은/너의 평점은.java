import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int dou = (int) Double.parseDouble(st.nextToken());
            String s = st.nextToken();
            int score = 0;
            cnt += dou;
            if (s.length() == 2) {
                switch (s.charAt(0)) {
                    case 'A' : score += 40; break;
                    case 'B' : score += 30; break;
                    case 'C' : score += 20; break;
                    default: score += 10; break;
                }
                if (s.charAt(1) == '+') score += 5;
            } else if (s.charAt(0) == 'P') cnt -= dou;
            answer += dou * score;
        }

        System.out.println((double) answer / cnt / 10);

    }
}

