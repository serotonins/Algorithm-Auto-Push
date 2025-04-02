import java.util.*;
import java.io.*;

public class Main {
    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        
        int c = read();
        int p = read();

        ArrayList<int[]> set = new ArrayList<>();
        if (p == 1) {
            set.add(new int[] {0});
            set.add(new int[] {0,0,0,0});
        } else if (p == 2) {
            set.add(new int[] {0,0});
        } else if (p == 3) {
            set.add(new int[] {0,0,1});
            set.add(new int[] {1,0});
        } else if (p == 4) {
            set.add(new int[] {1,0,0});
            set.add(new int[] {0,1});
        } else if (p == 5) {
            set.add(new int[] {0,0,0});
            set.add(new int[] {1,0});
            set.add(new int[] {0,1});
            set.add(new int[] {1,0,1});
        } else if (p == 6) {
            set.add(new int[] {0,0,0});
            set.add(new int[] {0,0});
            set.add(new int[] {2,0});
            set.add(new int[] {0,1,1});
        } else {
            set.add(new int[] {0,0,0});
            set.add(new int[] {0,0});
            set.add(new int[] {0,2});
            set.add(new int[] {1,1,0});
        }

        int[] map = new int[c];
        for (int i = 0; i < c; i++) {
            map[i] = read();
        }

        int answer = 0;

        for (int[] s : set) {
            for (int i = 0; i <= c-s.length; i++) {
                int g = map[i] - s[0];
                boolean ok = true;
                for (int j = 1; j < s.length; j++) {
                    if (s[j] != map[i+j] - g) {
                        ok = false;
                        break;
                    }
                }
                if (ok) answer++;
            }
        }

        System.out.println(answer);
    }
}

