import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {iter.next();}

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] arr = br.readLine().split(" ");
            char inst = arr[0].charAt(0);
            if (inst == 'L' && iter.hasPrevious()) {
                iter.previous();
            } else if (inst == 'D' && iter.hasNext()) {
                iter.next();
            } else if (inst == 'B' && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            } else if (inst == 'P') {
                iter.add(arr[1].charAt(0));
            }
        }

        for (char c : list) {
            bw.append(c);
        }
        bw.flush();
        bw.close();
    }
}

