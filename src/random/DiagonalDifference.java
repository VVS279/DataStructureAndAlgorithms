package random;

public class DiagonalDifference {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
    long dig1Sum = 0;
    long dig2Sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      dig1Sum += matrix[i][i];
      dig2Sum += matrix[i][matrix.length - i - 1];
    }
    long diff = Math.abs(dig2Sum - dig1Sum);
    System.out.println(diff);
  }
}
