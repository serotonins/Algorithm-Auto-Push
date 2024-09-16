import java.util.*;
import java.io.*;

public class Main {

    static class Person {
        int y, x, r;
        public Person(int y, int x, int r) {
            this.y = y;
            this.x = x;
            this.r = r;
        }
    }

    public static int pow(int num) { return num * num; }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            Person cho = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Person baek = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int answer = 0;
            long d = pow(cho.y - baek.y) + pow(cho.x - baek.x);

            if (d == 0) {
                if (cho.r == baek.r) answer = -1;
                else answer = 0;
            }
            else if (d < pow(cho.r) || d < pow(baek.r)) {
                if (baek.r < cho.r) {
                    if (Math.sqrt(d) + baek.r < cho.r) answer = 0;
                    else if (Math.sqrt(d) + baek.r == cho.r) answer = 1;
                    else answer = 2;
                } else {
                    if (Math.sqrt(d) + cho.r < baek.r) answer = 0;
                    else if (Math.sqrt(d) + cho.r == baek.r) answer = 1;
                    else answer = 2;
                }
            }
            else if (pow(cho.y - baek.y) + pow(cho.x - baek.x) == pow(cho.r + baek.r)) answer = 1;
            else if (pow(cho.y - baek.y) + pow(cho.x - baek.x) < pow(cho.r + baek.r)) answer = 2;

            System.out.println(answer);
        }

    }
}

