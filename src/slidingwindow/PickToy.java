package slidingwindow;

import java.util.HashMap;


// Variable Size Sliding Window
public class PickToy {

   public static void main(String[] args) {
    String str = "abaccacba";
    int i = 0;
    int j = 0;
    int max = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    
    while (j < str.length()) {
      
      char charj = str.charAt(j);
      if (map.containsKey(charj)) {
        map.put(charj, map.get(charj) + 1);
      } else {
        map.put(charj, 1);
      }
      
      //conditions and calculating answer
      if (map.size() <= 2) {
        int sum = map.values().stream().mapToInt(e -> e).sum();
        if (max < sum) {
          max = sum;
        }
      } else {
        //sliding the window and maintaining the calculation
        char ichar = str.charAt(i);
        if (map.get(ichar) == 1) {
         map.remove(ichar);
        } else {
          map.put(ichar, map.get(ichar) - 1);
        }
        i++;
      }
      j++;
    }
    System.out.println(max);
  }
}
