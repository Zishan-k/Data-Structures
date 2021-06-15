package BackTracking;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class AmazonQuestions {
    public static void main(String[] args) {
        //getNearestSmallestElement(new int[]{1, 3, 0, 2, 5});
        //getNearestSmallestElementOpt(new int[]{1, 3, 0, 2, 5});
        //System.out.println(Arrays.toString(q3(new int[]{1, 3, 0, 2, 5})));
        //System.out.println(checkClockwise("abcdef", "efabcd") || checkAntiClockwise("abcdef","efabcd"));
        //System.out.println(findPairWithProduct(new int[]{1,2,3,4,4,6,7}, 29));
        //System.out.println(replaceZeros(102));
        //System.out.println(getNumberOfOccurrences(new int[]{1, 2, 3, 3, 3, 3, 4, 6, 7, 8}, 3, 11));
        //System.out.println(clockAngle(3, 30));
        //System.out.println(getEquilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
        //System.out.println(binaryToDecimal(1010));
        //System.out.println(getBinaryOfDecimal(10));
        //System.out.println(getNoOfBitToConvertAtoB(10, 20));
        //System.out.println(findNoOccurringOddTimesIn(new int[]{1,1,3,3,4,6,5,6,6,4}));
        //System.out.println(fact(5));
        //System.out.println(fibo(3));
    }
    private static boolean doesSumExists(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (!set.isEmpty() && set.contains(k - j)) return true;
            else set.add(j);
        }
        return false;
    }

    private static int findNoOccurringOddTimesIn(int[] arr) {
        Map<Integer, Integer> valVsCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!valVsCount.containsKey(arr[i]))
                valVsCount.put(arr[i], 1);
            else {
                valVsCount.put(arr[i], valVsCount.get(arr[i]) + 1);
                if (valVsCount.get(arr[i]) % 2 == 1) return arr[i];
            }
        }
        return -1;
    }

    private static int getNoOfBitToConvertAtoB(int a, int b) {
        String binaryA = getBinaryOfDecimal(a), binaryB = getBinaryOfDecimal(b);
        int count = 0;
        for (int i = 0; i < binaryA.length(); i++) {
            if (binaryA.charAt(i) != binaryB.charAt(i))
                count++;
        }
        return count;
    }


    private static String getBinaryOfDecimal(int n) {
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            int temp = n % 2;
            str.append(temp);
            n /= 2;
        }
        return str.reverse().toString();
    }

    private static int binaryToDecimal(int n) {
        int ans = 0;
        for (int i = 0; n > 0; i++) {
            int temp = n % 10;
            if (temp != 0) ans = (int) (ans + Math.pow(2, i));
            n = n / 10;
        }
        return ans;
    }

    private static int getEquilibriumIndex(int[] arr) {
        int rightSum = 0, leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (rightSum == leftSum) return i;
            leftSum += arr[i];
        }
        return -1;
    }

    private static int clockAngle(int hour, int minute) {
        //getting hour hand resting angle - minute hand resting angle
        int ans = Math.abs((hour * 30) - ((minute / 5) * 30));

        //removing extra angle caused by minute hand
        return Math.abs(ans - (minute / 2));
    }

    private static int getNumberOfOccurrences(int[] arr, int x, int n) {
        int first = 0, last = n - 1;
        return getLastOccurrence(arr, x, first, last) - getFirstOccurrence(arr, x, first, last) + 1;
    }

    private static int getLastOccurrence(int[] arr, int x, int first, int last) {
        int mid = (first + last) / 2;
        if (arr[mid] == x && arr[mid + 1] != x)
            return mid;
        if (x == arr[mid])
            return getLastOccurrence(arr, x, mid + 1, last);
        else
            return getLastOccurrence(arr, x, first, mid - 1);
    }

    private static int getFirstOccurrence(int[] arr, int x, int first, int last) {
        int mid = (first + last) / 2;
        if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x))
            return mid;
        if (x == arr[mid] || arr[mid] > x)
            return getFirstOccurrence(arr, x, first, mid - 1);
        else
            return getFirstOccurrence(arr, x, mid + 1, last);
    }

    //102
    private static int replaceZeros(int num) {
        int ans = 0;
        int i = num;
        while (i > 0) {
            int temp = i % 10;
            if (temp == 0) temp = 5;
            ans = ans * 10 + temp;
            i = i / 10;
        }
        return ans;
    }

    private static boolean findPairWithProduct(int[] arr, int x) {
        Set<Integer> intVsInt = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (intVsInt.contains(arr[i]))
                return true;

            if (x % arr[i] == 0) intVsInt.add(arr[i]);
        }
        return false;
    }

    private static boolean checkAntiClockwise(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int length = str1.length() - 1;
        for (int i = length; i >= 0; i--) {
            String subStr1 = str1.substring(0, i);
            String subStr2 = str2.substring(length - i, str1.length());
            if (subStr1.equals(subStr2)) {
                String subStr11 = str1.substring(i);
                String subStr22 = str2.substring(0, length - i);

                if (subStr11.equals(subStr22)) return true;
            }
        }
        return false;
    }

    private static boolean checkClockwise(String str1/*amazon*/, String str2/*azonam*/) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            //getting the common charseq from both the strings. eg: "cdef"
            String substring1 = str1.substring(i);
            String substring2 = str2.substring(0, str1.length() - i);

            //checking if the remaining charseq are common from both the strings. eg: "ab"
            if (substring2.equals(substring1)) {
                String substring11 = str1.substring(0, i);
                String substring22 = str2.substring(str1.length() - i, str1.length());
                if (substring11.equals(substring22))
                    return true;
            }
        }
        return false;
    }


    public static int[] q3(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        AtomicInteger i = new AtomicInteger();
        int j = 0;
        stack.push(-1);
        while (j < arr.length && !stack.isEmpty()) {
            if (stack.peek() < arr[j]) {
                // Step 1 -- add value to response array
                result[i.getAndIncrement()] = stack.peek();
                stack.push(arr[j]);
                j++;
            } else {
                // step 2 -- here we have to pop if value
                stack.pop();
            }
        }
        return result;
    }


    /*
*
Input:  arr[] = {1, 6, 4, 10, 2, 5}
Output:         {_, 1, 1,  4, 1, 2}
*s: -1, 1, 2
*res: -1, 1, 1, 4, 1, 5
*
First element ('1') has no element on left side. For 6,
there is only one smaller element on left side '1'.
For 10, there are three smaller elements on left side (1,
6 and 4), nearest among the three elements is 4.

Input: arr[] = {1, 3, 0, 2, 5}
Output:        {_, 1, _, 0, 2}
*
* stack : 0 2
* op: - 1 - 0 2
*
* */
    private static void getNearestSmallestElementOpt(int[] arr) {
        /*Stack<Integer> stack = new Stack<>();
        System.out.print("_" + " ");
        stack.push(-99);
        int i = 0;
        while (i < ints.length && !stack.empty()) {
            if (stack.peek() < ints[i]) {
                System.out.print(stack.peek() + " ");
                stack.push(ints[i]);
                i++;
            } else {
                stack.pop();
            }
        }*/
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int i = 0;
        while (i < arr.length) {
            int temp = stack.peek();
            if (temp < arr[i]) {
                System.out.println(temp);
                stack.push(arr[i]);
                i++;
            } else {
                stack.pop();
            }
        }
    }

    private static void getNearestSmallestElement(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (ints[j] < ints[i]) {
                    System.out.print(ints[j] + ", ");
                    break;
                }
            }
            if (j == -1) System.out.print("_" + ", ");
        }
    }
}
