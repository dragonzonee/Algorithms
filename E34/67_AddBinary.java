Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


    //从后往前加，当前位次的值为 sum%2, 进位为 sum/2
    //算出一个结果之后记得调用reverse()方法，因为计算时是从后往前算的
    public String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1, j=b.length()-1;
        int carry = 0;
        while(i>=0||j>=0){
            int sum = carry;
            if(i>=0) sum += a.charAt(i--) - '0';
            if(j>=0) sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }