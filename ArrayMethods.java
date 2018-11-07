public class ArrayMethods{
   public static int rowSum(int[][] ary, int x){
    int value = 0;
    if (x >= ary.length){
      return 0;
    }
    for (int i = 0; i < ary[x].length; i++){
      value = ary[x][i] + value;
    }
    return value;
  }

   public static int columnSum(int[][] ary, int x){
    int value = 0;
    for (int i = 0; i < ary.length; i++){
     if (x < ary[i].length){
       value += ary[i][x];
     }
    }
    return value;
  }
    //returns the sum of the elements in Column x of ary (careful with rows of different lengths!).
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)

   /*
   *PART 2 - use prior methods where appropriate
   */
   public static int[] allRowSums(int[][] ary){
     int[] returnValue = new int[ary.length];
     for (int i = 0; i < ary.length;i++){
       returnValue[i] = rowSum(ary, i);
     }
     return returnValue;
   }

    //returns an array of the row sums for each row of ary.
    //Index i of the return array contains the sum of elements in row i.

    public static int[] allColSums(int[][] ary){
      int largestLength = 0;
      for (int i=0; i<ary.length;i++){
        if (ary[i].length > largestLength){
          largestLength = ary[i].length;
        }
      }
      int[] returnValue = new int[largestLength];
      for(int a = 0; a < largestLength; a++){
        returnValue[a] = columnSum(ary, a);
      }
      return returnValue;
}
    //Returns an array with the column sum of each column of ary.
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)
    //Index i of the return array contains the sum of elements in column i, ignoring any rows that are too short.
    //The length of the returned array should be the length of the LONGEST array in ary.


   /*
   *PART 3 - use prior methods where appropriate
   */
   public static boolean isRowMagic(int[][] ary){
     int[] equal = allRowSums(ary);
     boolean returnValue = true;
     for (int i = 0; i < equal.length - 1; i++){
       if (!(equal[i] == equal[i + 1])){
         returnValue = false;
       }
     }
     return returnValue;
   }
     //checks if the array is row-magic (this means that every row has the same row sum).

   public static boolean isColumnMagic(int[][] ary){
     int[] equal = allColSums(ary);
     boolean returnValue = true;
     for (int i = 0; i < equal.length - 1; i++){
       if (!(equal[i] == equal[i + 1])){
         returnValue = false;
       }
     }
     return returnValue;
   }
    //checks if the array is column-magic (this means that every column has the same column sum).
}
