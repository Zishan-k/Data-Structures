package BackTracking;

public class Recursion {
    public static void main(String[] args) {
        //printNaturalNos(10);
        //printNaturalNosInDecOrder(5);
        //printSeqIncDec(5);

        /*imp:
         * Given a value n, how many binary strings of length n are there without any consecutive 1's?
         * */
        //System.out.println(noOfBinaryStrWithNoConsecutiveOnes(3));

    }



    private static int noOfBinaryStrWithNoConsecutiveOnes(int n) {
        if(n == 0) return 2;
        if(n == 1) return 3;
        int t1 = noOfBinaryStrWithNoConsecutiveOnes(n - 1);
        int t2 = noOfBinaryStrWithNoConsecutiveOnes(n - 2);
        return t1 + t2;
    }

    private static void printSeqIncDec(int n) {
        if(n == 1) {
            System.out.println(n); return;
        }
        System.out.println(n);
        printSeqIncDec(n - 1);
        System.out.println(n);
    }

    private static void printNaturalNosInDecOrder(int n) {
        if(n == 0) return;
        System.out.println(n);
        printNaturalNosInDecOrder(n-1);
    }

    private static void printNaturalNos(int n) {
        //1: Base case or smallest sub problem with solution
        if (n == 0) {
            return;
        }
        //2: Anyhow print 1...n-1 digits i.e get results of f(n-1) any how
        printNaturalNos(n - 1);

        //self work : print(n).We're printing when we'll be coming back i.e. when we're popping out the stack frames
        System.out.println(n);
    }

    private static int fibo(int n) {
        if (n == 1 || n == 0) return n;
        int prev1 = fibo(n - 1);
        int prev2 = fibo(n - 2);
        return prev1 + prev2;
    }

    private static int fact(int n) {
        if (n == 1) return 1;
        int temp = fact(n - 1);
        return n * temp;
    }

}
