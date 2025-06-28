import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void write(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n-1];
        int[] price = new int[n];

        write(distance);
        write(price);


        int minPrice = Integer.MAX_VALUE;
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            answer += (long) minPrice * distance[i];
        }

        System.out.println(answer);

    }
}

