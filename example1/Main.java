package example1;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc= new Scanner(new File(args[0]));
            // PrintWriter out = new PrintWriter(args[1]);
            
            while (sc.hasNext()) {
                int n = Integer.parseInt(sc.nextLine());
                int count = 0;

                String sb = "[";
                for (int i = 6; i <= n; i++) {
                    if (isPerfect(i)) {
                        count++;
                        sb = sb + i + " ";
                    }
                }
                sb += "]";
                sb = count + " " + sb;
                
                System.out.println(sb);
            }

            // out.close();
            sc.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isPerfect(int n) {
        if (n < 6) return false;
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (i * i == n) {
                sum += i;
            } else if (n % i == 0) {
                sum += i;
                sum += n / i;
            }
        }
        return sum == n;
    }
}
