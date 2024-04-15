import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Array to store denominations.
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> ans = new ArrayList<>();
        int m = denominations.length;

        // Pick coins in decreasing order of their values.
        for (int i = m - 1; i >= 0; i--) {
            while (n >= denominations[i]) {
                n = n - denominations[i];
                ans.add(denominations[i]);
            }
        }

        return ans;
    }
}