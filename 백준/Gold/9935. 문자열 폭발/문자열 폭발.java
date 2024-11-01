import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String bomb = br.readLine();
        int len = str.length();
        int blen = bomb.length();

        ArrayDeque<Character> que = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            que.push(str.charAt(i));

            if (que.size() >= blen) {
                for (int j = blen-1; j >= 0; j--) {
                    char c = que.pop();
                    if (bomb.charAt(j) != c) {
                        que.push(c);
                        for (int k = j+1; k < blen; k++) {
                            que.push(bomb.charAt(k));
                        }
                        break;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!que.isEmpty()) {
            answer.append(que.pollLast());
        }

        System.out.println(answer.toString().equals("") ? "FRULA" : answer.toString());
    }
}

