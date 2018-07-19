class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int cnt = --counts[c - 'a'];
            if (cnt == 0) {
                while (!dq.isEmpty() && dq.peekFirst() < c) {
                    char cc = dq.pollFirst();
                    sb.append(cc);
                    counts[cc - 'a'] = -1;
                }
                if (!dq.isEmpty() && dq.peekFirst() == c) {
                    dq.pollFirst();
                } else {
                    dq.clear();
                }
                sb.append(c);
            } else if (cnt > 0 && !dq.contains(c)) {
                while (!dq.isEmpty() && dq.peekLast() > c) {
                    dq.pollLast();
                }
                dq.offerLast(c);
            }
        }
        return sb.toString();
    }
}