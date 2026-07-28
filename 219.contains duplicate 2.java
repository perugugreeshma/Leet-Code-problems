import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove the element that is out of the k-sized window
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            
            // If the element already exists in the window, a duplicate is found
            if (!window.add(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
}
