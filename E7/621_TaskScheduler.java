Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.



    /* considering a tasks AAABBBBCCCC, n = 2;
     * find the character with highest frequency (maxLen) and how many of those characters, here are B and C with maxLen (4)
     * there are two characters with maxLen, so count = 2; 
     * in order to accormodate all B and C, at least we need;
     * C B _ C B _ C B _ C B  (max - 1) * (1 + n) + count, 
     * all other characters can be placed in the idle position, or squeeze in the middle
     * int this we can put A as C B A C B A C B A C B;
     * if the task is AAADDDBBBBCCCC, n = 2;
     * after putting A, all idle positions are occupied, so squeeze D in to the sequence as
     * C B A D C B A D C B A D C B
     */
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            int max = 0, sameNum = 0;
            for (char c : tasks) {
                int index = c - 'A';
                map[index]++;
                if (map[index] == max) sameNum++;
                else if (map[index] > max) {
                    max = map[index];
                    sameNum = 0;
                }
            }
            return Math.max((max - 1)*n + max + sameNum, tasks.length);        
        }
    }