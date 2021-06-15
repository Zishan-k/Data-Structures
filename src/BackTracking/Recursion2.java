package BackTracking;

public class Recursion2 {
    public static void main(String[] args) {
        /*There are N people who want to go to a party.
        There is a constraint that any person can either go alone or can go in a pair.
        Calculate the number of ways in which N persons will go to party.
        Eg: N = 3 output: 4
        explanation: a b c
                     ab c
                     ac b
                     bc a
        */
        //System.out.println(countWays(3));

        /*Given two numbers a and b, calculate a^b recursively.*/
        //System.out.println(calculatePower(2,4));
        //System.out.println(calculatePowerOptimized(2, 4));

        /*Given a value of n, print pattern of n rows recursively.
         * for n = 4, pattern:
         *                       * * * *
         *                       * * *
         *                       * *
         *                       *
         * */
        //printPatternRecursively(4);
        //printPatternRecursively1(4, 0);

        /*Given a value of n, print this pattern.
         *       *
         *       * *
         *       * * *
         *       * * * *
         * */
        //recursivePattern2(5);

        /*Given an array, print all the subsets of the array.*/
        //int[] arr1 = new int[]{1, 2, 3};
        //printSubsets(arr1, 0, arr1.length, "");

        //Given a value n, how many binary strings of length n are there without any consecutive 1's?
        //todo
        noConsecutiveOnes(3, "");


        //Given an array, check if it is sorted or not?
        //int[] arr = new int[]{1,2,5 ,4};
        //System.out.println(checkSort(arr, 0, arr.length));
    }

    private static void noConsecutiveOnes(int n, String osf) {
        if(osf.length() == n){
            System.out.println(osf);
            return;
        }

        noConsecutiveOnes(n, osf + "0");
        if(!osf.isEmpty() && osf.charAt(osf.length() - 1) != '1')
            noConsecutiveOnes(n, osf + "1");
        else if(osf.isEmpty())
            noConsecutiveOnes(n, osf+"1");
    }

    private static boolean checkSort(int[] arr, int i, int length) {
        if(i == length - 1) return true;

        if(arr[i] > arr[i+1]) return false;

        return checkSort(arr, i + 1, length);

    }

    private static void printSubsets(int[] arr, int index, int length, String outputSoFar) {
        if (index == length) {
            System.out.println("[" + outputSoFar + "]");
            return;
        }
        //including the element
        printSubsets(arr, index + 1, length, outputSoFar + arr[index]);

        //not including the element
        printSubsets(arr, index + 1, length, outputSoFar);
    }

    private static void recursivePattern2(int n) {
        if (n == 0) return;
        if (n > 0) recursivePattern2(n - 1);
        printPattern(n);
        System.out.println();

    }

    private static void printPattern(int n) {
        if (n == 0) return;
        if (n > 0) {
            System.out.print("* ");
            printPattern(n - 1);
        }
    }

    private static void printPatternRecursively1(int n, int i) {
        if(n == 0) {
            return;
        }
        if(i != n) {
            System.out.print("* ");
            printPatternRecursively1(n, i + 1);
        } else {
            System.out.println();
            printPatternRecursively1(n - 1, 0);
        }
    }

    static int i = 0;
    private static void printPatternRecursively(int n) {
        if (n == 0) {
            System.out.println();
            return;
        }
        System.out.print("* ");
        i++;
        printPatternRecursively(n - 1);
        i--;
        if (i == 0)//change row
            printPatternRecursively(n - 1);

    }

    /*
     * if b is even a^4 = a^2 * a^2
     * else         a^5 = a * a^2 * a^2
     * */
    private static int calculatePowerOptimized(int a, int b) {
        if (b == 1) return a;
        if (b == 0) return 1;
        int temp = calculatePowerOptimized(a, b / 2);
        if (b % 2 == 0)
            return temp * temp;
        else
            return a * temp * temp;
    }

    private static int calculatePower(int a, int b) {
        if (b == 1) return a;
        int res = calculatePower(a, b - 1);
        return a * res;
    }

    private static int countWays(int n) {
        if (n == 1 || n == 2) return n;
        int forCaseAlone = countWays(n - 1);
        int forCasePair = countWays(n - 1) * countWays(n - 2);
        return forCaseAlone + forCasePair;
    }
}
