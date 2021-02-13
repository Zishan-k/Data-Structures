//Amazon: Check if a string can be obtained by rotating another string 2 places
public class StringRotatedBy2Places {
    private static boolean checkStrings(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        else {
            //Checking substring from s1 from i to len-1 and comparing it with substring of s2 from 0 to len - i
            for (int i = 0; i < s1.length(); i++) {
                if(s1.substring(i).equals(s2.substring(0, s2.length() - i))){
                    if(s1.substring(0, i).equals(s2.substring((s2.length() - i)))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkStrings("amazon","azonam"));
    }
}
