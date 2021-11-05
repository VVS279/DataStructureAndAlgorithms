package random;

class EvenArraySwap {

  static void minimumSwaps(int arr1[], int arr2[]) {

    int sumArr1 = 0, sumArr2 = 0;
    int evenIndex1 = -1;
    int evenIndex2 = -1;

    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] % 2 == 0)
        evenIndex1 = i;
      sumArr1 += arr1[i];
    }

    for (int i = 0; i < arr2.length; i++) {
      if (arr2[i] % 2 == 0)
        evenIndex2 = i;
      sumArr2 += arr2[i];
    }
    if (sumArr1 % 2 == 0 && sumArr2 % 2 == 0) {
      System.out.print(0);
      return;
    }

    if (sumArr1 % 2 != 0 && sumArr2 % 2 != 0) {
      if (sumArr1 % 2 != 0) {
        if (evenIndex2 != -1) {
          System.out.println(1);
          return;
        }
      }
      if (sumArr2 % 2 != 0) {
        if (evenIndex1 != -1) {
          System.out.println(1);
          return;
        }
      }
    }

    System.out.print(-1);
  }

  public static void main(String[] args) {
    int arr1[] = { 3, 6};
    int arr2[] = { 3, 3, 3};

    minimumSwaps(arr1, arr2);
  }
}