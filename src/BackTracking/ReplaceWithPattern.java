package BackTracking;

public class ReplaceWithPattern {
    public static void main(String[] args) {
        replace("ababaaababababaaab","ab");
    }

    private static void replace(String string, String pattern) {
        System.out.println(string.replaceAll(pattern, "X"));
    }




}
