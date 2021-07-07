package BackTracking;

import java.util.Stack;

public class RecursionProblems {
    private static void binarySeq(int n, int i, String osf) {
        if (i >= n) {
            System.out.println(osf);
            return;
        }
        binarySeq(n, i + 1, osf + "0");
        binarySeq(n, i + 1, osf + "1");
    }

    private static void stringOfDigits(String str, int i, String output) {
        if (i >= str.length()) {
            System.out.println(output);
            return;
        }
        char c = str.charAt(i);
        stringOfDigits(str, i + 1, output + c + " ");
        if (str.length() - 1 != i)
            stringOfDigits(str, i + 1, output + c);
    }

    private static int recursiveAtoi(String s, int i, int n) {
        if (i >= s.length())
            return n;
        int temp = n * 10 + (s.charAt(i) - '0');
        return recursiveAtoi(s, i + 1, temp);
    }

    private static void printStringsFromSet(char[] charSet, String ansStr, int k) {
        if (ansStr.length() == k) {
            System.out.println(ansStr);
            return;
        }
        for (int i = 0; i < charSet.length; i++) {
            printStringsFromSet(charSet, ansStr + charSet[i], k);
        }
    }


    private static boolean checkPalindrome(int n, int ans, int orNo) {
        if (ans == orNo) return true;
        if (n > 0) {
            int rem = n % 10;
            n = n / 10;
            return checkPalindrome(n, ans * 10 + rem, orNo);
        }
        return false;
    }

    private static int checkConsonants(String str, int i, int totalCons) {
        if (i >= str.length())
            return totalCons;
        return checkConsonants(str, i + 1, (str.charAt(i) != 'a' &&
                str.charAt(i) != 'e' &&
                str.charAt(i) != 'i' &&
                str.charAt(i) != 'o' &&
                str.charAt(i) != 'u' &&
                str.charAt(i) >= 97 &&
                str.charAt(i) <= 123) ? totalCons + 1 : totalCons);
    }

    private static char firstUppercaseLetterIn(String str, int i) {
        if (str.length() <= i) {
            return '-';
        }
        if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
            return str.charAt(i);
        return firstUppercaseLetterIn(str, i + 1);
    }

    private static void powerSetOf(String str, int i, String ans) {
        if (i >= str.length()) {
            System.out.println(ans);
            return;
        }
        powerSetOf(str, i + 1, ans + str.charAt(i));
        powerSetOf(str, i + 1, ans);
    }

    private static int findMax(int[] arr, int i, int max) {
        if (arr[i] > max) max = arr[i];
        if (i >= arr.length - 1) return max;
        return findMax(arr, i + 1, max);
    }

    private static int binarySearch(int[] arr, int d, int first, int last) {
        int mid = (first + last) / 2;
        if (arr[mid] == d) return mid;
        if (d > arr[mid]) return binarySearch(arr, d, mid + 1, last);
        else return binarySearch(arr, d, first, mid - 1);
    }


    private static void insertAtBottomInStack(Stack<Integer> stack, int a) {
        if (stack.isEmpty()) {
            stack.push(a);
            return;
        }
        int temp = stack.pop();
        insertAtBottomInStack(stack, a);
        stack.push(temp);
    }

    private static void reverseStack(Stack<Integer> stack, int popped) {
        if (stack.isEmpty()) {
            return;
        }
        popped = stack.pop();
        reverseStack(stack, popped);
        insertAtBottomInStack(stack, popped);
    }

    private static void sortStack(Stack<Integer> stack, int popped) {
        if (stack.isEmpty()) {
            return;
        }
        popped = stack.pop();
        sortStack(stack, popped);
        insertAtItsPosition(stack, popped);
    }

    private static void insertAtItsPosition(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        if (stack.peek() < x) stack.push(x);
        else {
            int temp = stack.pop();
            insertAtItsPosition(stack, x);
            stack.push(temp);
        }
    }

    private static String swapStringChars(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    private static void permutationsOpt(String str, int j) {
        if (j == str.length() - 1) {
            System.out.println(str);
            return;
        }
        for (int i = j; i < str.length(); i++) {
            str = swapStringChars(str, i, j);
            permutationsOpt(str, j + 1);
            str = swapStringChars(str, i, j);

        }
    }

    public static void main(String[] args) {
        //permutationsOpt("abc", 0);
        /*MyLinkedListMain head = new MyLinkedListMain();
        head.insert(head, 1);
        head.insert(head, 2);
        head.insert(head, 3);
        head.insert(head, 4);
        head.insert(head, 5);
        head.insert(head, 6);
        head.printList(head);
        head.remove(head,4, 0);
        head.printList(head);*/
        /*Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        sortStack(stack, 0);
        System.out.println(stack);*/
        /*int[] arr = new int[]{1,2,3,4,6,77,87,99,108,};
        System.out.println(binarySearch(arr, 99, 0, arr.length - 1));*/
        /*Given an input string of numbers,
        find all combinations of numbers that can be formed using digits in the same order.
        Examples:
        Input : 123
        Output :1 2 3
        1 23
        12 3
        123*/
        //stringOfDigits("123", 0, "");
        //System.out.println(checkConsonants("geeksforgeeks portal", 0, 0));
        //System.out.println(firstUppercaseLetterIn("abcDe", 0));
        powerSetOf("abc", 0, "");
        //System.out.println(findMax(new int[]{22,12,44,29,45}, 0, 0));
        //binarySeq(2, 0 , "");

        /*Input:
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb
*/
        //printStringsFromSet(new char[]{'a','b'}, "", 1);
        //System.out.println(recursiveAtoi("233",0,  0));
        //System.out.println(checkPalindrome(1211, 0, 121));
    }

}
