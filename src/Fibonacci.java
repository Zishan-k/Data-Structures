//Fibonacci Series using Recursion 
class Fibonacci
{
    static void iterateFibo(int n){
        //0,1,1,2,3
        int a= 0, b= 1, c;
        for (int i = 0; i < n; i++) {
            c = a + b;
            b = a;
            a = c;
            System.out.print(a + " ");
        }
    }

    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }



    public static void main (String args[])
    {
        int n = 5;
        System.out.println(fib(n));
        iterateFibo(n);
    }
} 