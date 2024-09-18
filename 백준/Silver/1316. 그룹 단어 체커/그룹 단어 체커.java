import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int answer = 0;
        boolean[] first = new boolean[26];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean group = true;
            first = new boolean[26];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (first[c-'a']) {
                    group = false;
                    break;
                }
                first[c-'a'] = true;
                for (int k = j+1; k < s.length(); k++) {
                    if (s.charAt(k) != c) {break;}
                    j++;
                }
            }
            if (group) answer++;
        }

        System.out.println(answer);
    }
}

