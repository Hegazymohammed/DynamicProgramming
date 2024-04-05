package leetCode30DaysChallenges;

public class Leetcode79 {
     
        public boolean exist(char[][] board, String word) {
            //First need to find every index that i can start with
         /*
           move int three direction <--N -->
                                       |

         */
            int row=board.length;
            int column=board[0].length;
            int expected=0;
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(word.charAt(0)==board[i][j]){
                        expected= search(i,j,board, word,0);
                        System.out.println(expected);
                        if(expected==word.length() )
                            return true;
                }
                }

            }
            return expected==word.length()-1;

        }
        private boolean isValid(int row,int column,char[][]grid){
            if(row>=grid.length||row<0)
                return false;
            if(column>=grid[0].length||column<0)
                return false;
            return true;
        }
        private  int  search(int row,int column,char[][]grid,String word,int remain){
            if(remain==word.length()||!isValid(row,column,grid))
                return 0;
            int result=0;
            if(word.charAt(remain)==grid[row][column]){
                int choice1=1+search(row,column+1,grid,word,remain+1);
                int choice2=1+search(row+1,column,grid,word,remain+1);
                int choice3=1+search(row,column-1,grid,word,remain+1);
              return Math.max(choice1,Math.max(choice2,choice3));
            }

            else
                return 0;
        }
     

    public static void main(String[] args) {
        Leetcode79 sol=new Leetcode79();
        char [][]grid={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(sol.exist(grid,  "ABCB"));
    }
}
