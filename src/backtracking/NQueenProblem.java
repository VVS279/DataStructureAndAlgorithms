package backtracking;

public class NQueenProblem {
  static int N;

  /*
   * ld is an array where its indices indicate row-col+N-1 (N-1) is for shifting
   * the difference to store negative indices
   */
  static int[] ld;

  /*
   * rd is an array where its indices indicate row+col and used to check whether a
   * queen can be placed on right diagonal or not
   */
  static int[] rd;

  /*
   * column array where its indices indicates column and used to check whether a
   * queen can be placed in that row or not
   */
  static int[] cl = new int[30];

  /* A utility function to print solution */
  static void printSolution(int board[][]) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.printf(" %d ", board[i][j]);
      System.out.printf("\n");
    }
  }

  /*
   * A recursive utility function to solve N Queen problem
   */
  static boolean solveNQUtil(int board[][], int row) {
    /*
     * base case: If all queens are placed then return true
     */
    if (row >= N)
      return true;

    /*
     * Try placing this queen in all column one by one
     */
    for (int i = 0; i < N; i++) {

      /*
       * Check if the queen can be placed on board[row][col]
       */
      /*
       * A check if a queen can be placed on board[row][col].We just need to check
       * rd[row-col+n-1] and ld[row+coln] where ld and rd are for left and right
       * diagonal respectively
       */
      if ((rd[row - i + N - 1] != 1 && ld[row + i] != 1) && cl[i] != 1) {
        /* Place this queen in board[row][i] */
        board[row][i] = 1;
        rd[row - i + N - 1] = ld[row + i] = cl[i] = 1;

        /* recur to place rest of the queens */
        if (solveNQUtil(board, row + 1))
          return true;

        /*
         * If placing queen in board[i][col] doesn't lead to a solution, then remove
         * queen from board[i][col]
         */
        board[row][i] = 0; // BACKTRACK
        rd[row - i + N - 1] = ld[row + i] = cl[i] = 0;
      }
    }

    /*
     * If the queen cannot be placed in any row in this colum col then return false
     */
    return false;
  }

  /*
   * This function solves the N Queen problem using Backtracking. It mainly uses
   * solveNQUtil() to solve the problem. It returns false if queens cannot be
   * placed, otherwise, return true and prints placement of queens in the form of
   * 1s. Please note that there may be more than one solutions, this function
   * prints one of the feasible solutions.
   */
  static boolean solveNQ() {
    int board[][] = new int[5][5];

    if (solveNQUtil(board, 0) == false) {
      System.out.printf("Solution does not exist");
      return false;
    }

    printSolution(board);
    return true;
  }

  // Driver Code
  public static void main(String[] args) {
    N = 5;
    ld = new int[2 * N - 1];
    rd = new int[2 * N - 1];
    solveNQ();
  }
}
