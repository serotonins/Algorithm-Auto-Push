import java.util.*;
import java.io.*;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        System.out.println(n>m?"flight":"high speed rail");
    }
}

