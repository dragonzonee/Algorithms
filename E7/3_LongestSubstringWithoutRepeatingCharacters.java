Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

class Solution {
    //abca
    //abba a-1 ab-2 abb-1 abba-2
    //This problem is not as easy as you think, treaks is how to calculate stIdx
    
    public int lengthOfLongestSubstring(String s){
        if(s==null||s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int stIdx = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            stIdx = Math.max(stIdx,map.containsKey(s.charAt(i))?map.get(s.charAt(i))+1:0);
            res = Math.max(i-stIdx+1,res);
            map.put(s.charAt(i),i);
        }
        return res;
    }
}