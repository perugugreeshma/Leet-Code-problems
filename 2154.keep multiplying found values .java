import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Store all numbers for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Keep multiplying while the value exists
        while (set.contains(original)) {
            original *= 2;
        }
        
        return original;
    }
}
