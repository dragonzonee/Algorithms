Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?


class Solution {
    public int countBattleships(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return 0;
        int num = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    checkShipLength(board,i,j);
                    num++;
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
        return num;
    }
    
    public void checkShipLength(char[][] board, int x, int y){
        if(board[x][y]=='X'){
            board[x][y] = '.';
            if(x<board.length-1) checkShipLength(board,x+1,y);
            if(x>0) checkShipLength(board,x-1,y);
            if(y<board[0].length-1) checkShipLength(board,x,y+1);
            if(y>0) checkShipLength(board,x,y-1);
        }else return;
    }
}