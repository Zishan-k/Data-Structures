package Recursion;

public class Recursion {

    /**
    1) Base case: fact(1) i.e. n = 1
    2) Relation between sub problem and current problem:
            (fact of 4) * 5 = fact(5)
    3) Generalize: fact(n) = n * fact(n-1)
    * */
    static int factorialOf(int n){
        if(n == 1){
            return 1;
        }
        return n * factorialOf(n-1);
    }

    /**
     1) Base case: a^0 i.e. b = 0
     2) Relation: 2^3 * 2 = 2^4
     3) Generalize: power(a,b) = a * power(a, b-1)
     * */
    static int power(int a, int b){
        calls++;
        if(b == 0){
            return 1;
        }
        return power(a, b-1) * a;
    }

    static int calls = 0;
    /**
     4^6 = (4^2)3
     4^7 = 4 * (4^2)^3
     * */
    static int fastPower(int a, int b){
        calls++;
        if(b == 0){
            return 1;
        }
        if(b % 2 == 0){
            return fastPower(a*a, b/2);
        }
        return a * fastPower(a, b-1);
    }


    /**
     1,1,2,3,5,8,13
     base case: n = 1
     Relation: fiboTill(5) = fiboTill(5-1) + fiboTill(5-2)
     * */
    static int fibonacciTill(int n){
        if(n <= 1){
            return n;
        }
        return fibonacciTill(n-1) + fibonacciTill(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibonacciTill(9));
    }
}
