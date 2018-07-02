//{(})
//))))
//((
class Solution {
    // public boolean isValid(String s) {
    //     if(s.length()==0) return true;
    //     Stack<Character> stack = new Stack<>();
    //     for(char c:s.toCharArray()){
    //         if(c=='(') stack.push(')');
    //         else if(c=='{') stack.push('}');
    //         else if(c=='[') stack.push(']');
    //         else if(stack.isEmpty()||stack.pop()!=c) return false;
    //     }
    //     return stack.isEmpty();
    // }
    
    public boolean isValid(String s){
        if(s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(')');
            else if(s.charAt(i)=='{') stack.push('}');
            else if(s.charAt(i)=='[') stack.push(']');
            else if(stack.isEmpty()||stack.pop()!=s.charAt(i)) return false;
        }
        return stack.isEmpty();
    }
}