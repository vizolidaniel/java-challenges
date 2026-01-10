package misc;

public class FizzBuzz {
    public void fizzBuzz(int n) {
        // Explanation:
        // Iterate from 1 to n.
        // Check divisibility by 3 and 5, print accordingly.
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        fb.fizzBuzz(15); // Expected: 1,2,Fizz,4,Buzz,...,FizzBuzz
    }
}

