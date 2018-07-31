A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = s.charAt(0)=='0'? 0:1;
        for(int i=2;i<res.length;i++){
            if(Integer.valueOf(s.substring(i-1,i))>0 && Integer.valueOf(s.substring(i-1,i))<10) res[i] = res[i-1];
            if(Integer.valueOf(s.substring(i-2,i))>=10 && Integer.valueOf(s.substring(i-2,i))<=26) res[i] += res[i-2];
        }
        return res[s.length()];       
    }
}