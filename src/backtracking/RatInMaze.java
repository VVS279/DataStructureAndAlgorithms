package backtracking;

public class RatInMaze {

  private static boolean solve(int[][] maze, int startX, int startY, int endX, int endY) {
   
    if(startX < 0 || startY < 0 || startX > endX || startY > endY) {
      return false;
    }

    if(maze[startX][startY] == 1) {
      maze[startX][startY] = 2;
      if (startX == endX && startY == endY) {
        return true;
      }
      
      if (solve(maze, startX + 1, startY, endX, endY)) {
        return true;
      }
      
      if (solve(maze, startX, startY + 1, endX, endY)) {
        return true;
      }
      
      if (solve(maze, startX -1, startY, endX, endY)) {
        return true;
      }
      
      if (solve(maze, startX, startY -1, endX, endY)) {
        return true;
      }
      
      maze[startX][startY] = 0;
      return false;
    }
    return false;
  }
  
  static void printSolution(int board[][]) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++)
        System.out.printf(" %d ", board[i][j]);
      System.out.printf("\n");
    }
  }
  
  public static void main(String[] args) {
    int maze[][] = { { 1, 0, 0, 0 },
                  { 1, 1, 0, 1 },
                  { 0, 1, 0, 0 },
                  { 1, 1, 1, 1 } };
    System.out.println(solve(maze, 0, 0, 3, 3));
    printSolution(maze);
    
  }

}
