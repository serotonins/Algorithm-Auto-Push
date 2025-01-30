import java.util.*;
import java.io.*;

public class Main {
    
    static String one, two;
    static int[][] lcs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        one = 1+br.readLine();
        two = 2+br.readLine();

        lcs = new int[one.length()][two.length()];

        char o, t;

        for (int i = 1; i < one.length(); i++) {
            o = one.charAt(i);
            for (int j = 1; j < two.length(); j++) {
                t = two.charAt(j);
                if (o == t) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        int preY = one.length()-1;
        int preX = two.length()-1;
        int preLen = lcs[preY][preX];
        while (preLen > 0) {
            if (lcs[preY-1][preX] == preLen) preY--;
            else if (lcs[preY][preX-1] == preLen) preX--;
            else {
                stack.push(one.charAt(preY));
                preLen = lcs[--preY][--preX];
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb.length());
        System.out.println(sb.toString());
    }
}

