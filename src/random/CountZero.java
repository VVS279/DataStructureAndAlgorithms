package random;

public class CountZero {
  
  public static void main(String[] args) {
    int fact = 30;
    int count = 0;
    for (int i = 5; i <= fact; i = i+5) {
      count += countZero(i);
    }
    System.out.println(count);
  }
  
  public static int countZero(int number) {
    int count = 0;
    if (number == 0) {
      return 0;
    }
    if (number%10 == 0) {
      count++;
      count += countZero(number/10);
    } else if (number%10 == 5) {
      count++;
    }
    return count;
  }

}
