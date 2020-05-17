import java.util.HashSet;
import java.util.Set;

public class Ds {
    public static void main(String[] args) {
        combination(5);
        values.forEach(val->{
            System.out.println(val);
        });
    }
    static Set<String> values = new HashSet<>();
    static char[] c  =new char[]{'A', 'B', 'C','D','E'};
   static String s ="";
    private static void combination(int n) {
        if(n < 1) {
            return;//tells to go back to its previous values stored in stack by recursion calls : BackTracking
        }

        for(int i = 1; i< c.length ; i++) {
            combination(n - i); //4, 3, 2, 1
            for (int j = 0; j < c.length; j++) {
                if (j <= n) {
                    s += " ";
                }
                s+=c[j];
            }
            values.add(s.trim());
            s = "";
            for (int j = 0; j < c.length; j++) {
                if (j >= n) {
                    s += " ";
                }
               s+=c[j];
            }
            values.add(s.trim());
            s = "";
            for (int j = 0; j < c.length; j++) {
                if (j == n) {
                    s += " ";
                }
                s+=c[j];
            }
           values.add(s.trim());
            s = "";

        }
    }
}
