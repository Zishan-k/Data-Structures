package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringDupliChar {
    public static void PrintDupliChar(String input){
        char[] charArray = input.toCharArray();
        Map<Character,Integer> CI = new HashMap<Character,Integer>();

        for(Character c : charArray){
            if(CI.containsKey(c)){
                CI.put(c,CI.get(c)+1);
            }
            else{
                CI.put(c,1);
            }
        }
        Set<Map.Entry<Character,Integer>> entrySet = CI.entrySet();
        System.out.println("List of Duplicate Values:");
        for(Map.Entry<Character,Integer> entry : entrySet){
            if(entry.getValue()>1){
                System.out.printf("%s : %d %n",entry.getKey(),entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        PrintDupliChar("zakykhan");
        PrintDupliChar("YOYO");
        PrintDupliChar("zishanKhan");
    }
 }
