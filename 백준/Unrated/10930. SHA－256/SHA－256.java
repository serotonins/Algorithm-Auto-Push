import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(S.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : md.digest()) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
    }
}