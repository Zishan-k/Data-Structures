package Strings;

import java.util.ArrayList;
import java.util.List;

public class LargestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        if(s.length() == 1)
            return 1;
        List<Character> subStringList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (subStringList.contains(c)) {
                if (max < subStringList.size())
                    max = subStringList.size();
                int index = subStringList.indexOf(c);
                for (int j = 0; j <= index; j++) {
                    subStringList.remove(0);
                }
                subStringList.add(c);
            } else {
                subStringList.add(c);
            }
        }
        if (max < subStringList.size())
            max = subStringList.size();
        return max;
    }

    public static void main(String[] args) {
        LargestSubstring largestSubstring = new LargestSubstring();
        System.out.println(largestSubstring.lengthOfLongestSubstring("geeksforgeeks"));
    }
}
