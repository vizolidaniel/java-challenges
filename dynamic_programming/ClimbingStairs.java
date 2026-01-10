package dynamic_programming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // Explanation:
        // This is essentially the Fibonacci sequence.
        // dp[i] = dp[i-1] + dp[i-2], meaning we can reach step i
        // either from step i-1 (1 step) or step i-2 (2 steps).
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println("Ways to climb 5 stairs: " + cs.climbStairs(5)); // Expected: 8
    }
}

