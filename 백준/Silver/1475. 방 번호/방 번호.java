import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer[] arr = new Integer[9];
        Arrays.fill(arr, 0);
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            int num = (str.charAt(i) - '0');
            if (num == 9) { num = 6; }
            arr[num]++;
        }
        arr[6] = arr[6] / 2 + (arr[6] % 2 == 0 ? 0 : 1);
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(arr[0]);
    }
}

