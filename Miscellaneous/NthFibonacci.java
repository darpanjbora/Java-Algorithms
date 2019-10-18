package Miscellaneous;

class NthFibonacci {
    
    /*
    * Print the nth Fibonacci number for a given number, n
    * using recursion
    */
    
    static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }
    
    public static void main(String[ ] args) {
        
        int n = 5;
        System.out.println(fib(n));
        
    }
}
