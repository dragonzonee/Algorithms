Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?



class Solution {
//     public boolean isAnagram(String s, String t) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         for(int i=0;i<t.length();i++){
//             if(!map.containsKey(t.charAt(i))) map.put(t.charAt(i),1);
//             else map.put(t.charAt(i),map.get(t.charAt(i))+1);
//         }
        
//         for(int i=0;i<s.length();i++){
//             if(!map.containsKey(s.charAt(i))) return false;
//             else if(map.get(s.charAt(i))==1) map.remove(s.charAt(i));
//             else map.put(s.charAt(i),map.get(s.charAt(i))-1);
//         }
        
//         return map.isEmpty();
//     }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[128];
        
        for (char c : s.toCharArray()) {
            chars[c]++;
        }
        
        for (char c : t.toCharArray()) {
            chars[c]--;
        }
        
        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}