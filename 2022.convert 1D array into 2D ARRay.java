class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if conversion is possible
        if (original.length != m * n) {
            return new int[0][0];
        }
        
        int[][] result = new int[m][n];
        
        // Fill the 2D array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }
        
        return result;
    }
}
