class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while(i!=s.length()-1 && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + s.charAt(i+1) - '0';
                    i++;
                }
                res += num*sign;
            }else if(s.charAt(i)=='+'){
                sign = 1;
            }else if(s.charAt(i)=='-'){
                sign = -1;
            }else if(s.charAt(i)=='('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }else if(s.charAt(i)==')'){
                res = res*stack.pop()+stack.pop();
            }
        }
        return res;
    }
}