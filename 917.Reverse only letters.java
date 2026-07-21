class Solution {
    public String reverseOnlyLetters(String s) {
        char[] a = s.toCharArray();
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetter(a[i])) i++;
            while (i < j && !Character.isLetter(a[j])) j--;
            char t = a[i]; a[i] = a[j]; a[j] = t;
        }
        return new String(a);
    }
}
