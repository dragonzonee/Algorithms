Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                for(int k=0;k<words.length;k++){
                    int idx = 0;
                    char[] word = words[k].toCharArray();
                    if(board[i][j]==word[idx]&&!set.contains(words[k])){
                        boolean ret = searchWord(board,i,j,word,idx,visited);
                        if(ret) set.add(words[k]);
                    }
                }
            }
        }
        List<String> res = new ArrayList<>(set);
        return res;
    }
    
    public boolean searchWord(char[][] board, int x, int y, char[] word, int idx, boolean[][] visited){
        if(x<0||x>board.length-1||y<0||y>board[0].length-1||idx>word.length-1||visited[x][y]) return false;
        if(board[x][y]==word[idx]){
            if(idx==word.length-1) return true;
            visited[x][y] = true;
            boolean left = searchWord(board,x+1,y,word,idx+1,visited);
            boolean right = searchWord(board,x-1,y,word,idx+1,visited);
            boolean up = searchWord(board,x,y+1,word,idx+1,visited);
            boolean down = searchWord(board,x,y-1,word,idx+1,visited);
            visited[x][y] = false;
            return left||right||up||down;
            
        }
        return false;
    }
}