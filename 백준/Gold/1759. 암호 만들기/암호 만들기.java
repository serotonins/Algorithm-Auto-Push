import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[] alpha = new boolean[26];
    static Set<Character> moeum = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static TreeSet<String> answer = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    static void back(int p) {
        if (p >= 26 || sb.length() >= n) {
            if (sb.length() == n && cnt >= 1 && n-cnt >= 2) {answer.add(sb.toString());}
            return;
        }

        back(p+1);
        if (alpha[p]) {
            char a = (char) ('a' + p);
            if (moeum.contains(a)) {cnt++;}
            if (n-cnt < 2) {cnt--; return;}
            sb.append(a);
            back(p+1);
            sb.deleteCharAt(sb.length()-1);
            if (moeum.contains(a)) cnt--;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            alpha[st.nextToken().charAt(0) - 'a'] = true;
        }

        back(0);

        for (Iterator iter = answer.iterator(); iter.hasNext(); ) {
            System.out.println((String) iter.next());
        }
    }
}

