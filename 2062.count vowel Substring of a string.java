class Solution {
    public int countVowelSubstrings(String word) {
        int count =0;
        for(int i=0;i< word.length(); i++) {
            String sub ="";
            for(int j =i;j< word.length();j++) {
                char ch = word.charAt(j);
                if ("aeiou".indexOf(ch)== -1) break;
                sub += ch;
                if (sub.contains("a")&&sub.contains("e")&&sub.contains("i")&&sub.contains("o")&&sub.contains("u")){
                    count++;
                }
            }
        }
        return count;
    }
}
