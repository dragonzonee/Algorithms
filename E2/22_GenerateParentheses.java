// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,"",0,0,n);
        return res;
    }
    
    public void helper(List<String> ls, String s, int st, int end, int n){
        if(s.length()==n*2){ls.add(s); return;}
        if(st<n) helper(ls,s+"(",st+1,end,n);
        if(end<st) helper(ls,s+")",st,end+1,n);
    }
}