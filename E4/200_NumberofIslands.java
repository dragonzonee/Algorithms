Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

class Solution {
    public int numIslands(char[][] grid) {
        int counts = 1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    searchEdges(grid,i,j,++counts);
                }
            }
        }
        // for(int i=0;i<grid.length;i++){
        //     System.out.print("[ ");
        //     for(int j=0;j<grid[0].length;j++){
        //         System.out.print(grid[i][j]);
        //         System.out.print(" ");
        //     }
        //     System.out.print(" ]");
        //     System.out.println("");
        // }
        return counts-1;
    }
    
    public void searchEdges(char[][] grid,int i, int j, int count){
        if(grid[i][j]=='1'){
            grid[i][j] = (char)(count+'0');
            if(i>0) searchEdges(grid,i-1,j,count);
            if(i<grid.length-1) searchEdges(grid,i+1,j,count);
            if(j>0) searchEdges(grid,i,j-1,count);
            if(j<grid[0].length-1) searchEdges(grid,i,j+1,count);
        }
    }
}