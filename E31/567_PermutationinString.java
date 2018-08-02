Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] src = new int[26];
        if(s1.length()>s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            src[s1.charAt(i)-'a']++;
            src[s2.charAt(i)-'a']--;
        }
        if(checkZero(src)) return true;
        // a [b c d] e
        // a b [c d  e]
        for(int i=s1.length();i<s2.length();i++){
            src[s2.charAt(i)-'a']--;
            src[s2.charAt(i-s1.length())-'a']++;
            if(checkZero(src)) return true;
        }
        return false;
    }
    
    public boolean checkZero(int[] array){
        for(int num:array){
            if(num!=0) return false;
        }
        return true;
    }
}