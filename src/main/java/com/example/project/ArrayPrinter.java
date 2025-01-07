package com.example.project;


public class ArrayPrinter {
    /** Returns a String representing the array of ints as a
     *  printable String, including open and closing brackets,
     *  with values separated by commas.
     *
     *  For example, if numList is [4, 7, 3], this method should return the
     *  String: "[4, 7, 3]" (with brackets and commas in between)
     *
     *  PRECONDITION: numList.length > 0
     */
    public static String printableString(int[] numList) {
      String str = "[";
      
      // iterate through all elements, EXCEPT the last one (which we will
      // append after the loop); so terminate loop when i < numList - 1
      for (int i = 0; i < numList.length - 1; i++) {
        str += numList[i];
        str += ", ";
      }
      int lastIndex = numList.length - 1;
      str += numList[lastIndex];
      str += "]";
      
      return str;
    }
}
  