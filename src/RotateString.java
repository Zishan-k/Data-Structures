/*
Given two strings, the task is to find if a string can be obtained by rotating another string two places.
Examples:
Input: string1 = “amazon”, string2 = “azonam”
Output: Yes
// rotated anti-clockwise

Input: string1 = “amazon”, string2 = “onamaz”
Output: Yes
// rotated clockwise
*/

public class RotateString {
    boolean isRotated(String str1,String str2){
        if(str1.length() != str2.length()) {
            return false;
        }

        String anti_clockwise = "";
        String clockwise = "";
        int len = str2.length();

        anti_clockwise = anti_clockwise + str2.substring(len-2,len) + str2.substring(0,len-2);
        clockwise = clockwise + str2.substring(2) + str2.substring(0,2);

        return str1.equals(anti_clockwise) || str1.equals(clockwise);
    }

    public static void main(String args[]){
        RotateString a= new RotateString();
        System.out.println(a.isRotated("amazon","azonam"));
    }
}


