Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.


The trick is first use 
	string.trim() 
function to get rid of useless space
Then use
	Character.isDigit()
method to check if the character is a number

The first character could be -/+, first analyse them
THE TRICKY PART is to remember add a START pointer 
The reason is 
	123
	-123
	+123
for all three cases above, we need different start pointer to start calculate 

Define a num and use
	num = 10*num + str.charAt(i) - '0'
to calculate

Remember to check OVERFLOW at the END of each iteration, check at the front could also cause a bug
at the very corner 2^31-1

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str==null||str.length()==0) return 0;
        int sign = 1, st = 0;
        long num = 0;
        if(str.charAt(0)=='-'){
            sign = -1;
            st++;
        }else if(str.charAt(0)=='+'){
            st++;
        }
        for(int i=st;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))) return sign*(int)num;
            else num = num*10 + str.charAt(i) - '0';
            if(num*sign>Integer.MAX_VALUE||num*sign<Integer.MIN_VALUE) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int)num*sign;
    }
}