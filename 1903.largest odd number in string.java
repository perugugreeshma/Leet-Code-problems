class Solution {
    public String largestOddNumber(String num) {
        // Scan the string from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current character is an odd digit
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return the substring from the beginning up to this digit
                return num.substring(0, i + 1);
            }
        }
        // Return an empty string if no odd digit is found
        return "";
    }
}
