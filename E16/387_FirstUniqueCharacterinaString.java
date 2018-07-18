Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.


class Solution {
    // public int firstUniqChar(String s) {
    //     for(int i=0;i<s.length();i++){
    //         if(s.indexOf(s.substring(i,i+1))==s.lastIndexOf(s.substring(i,i+1))) return i;
    //     }
    //     return -1;
    // }
    
     public int firstUniqChar(String s) {
         char[] src = new char[26];
         for(char c:s.toCharArray()){
             src[c-'a']++;
         }
         for(int i=0;i<s.length();i++){
             if(src[s.charAt(i)-'a']==1) return i;
         }
         return -1;
     }
}