package practice.corealgorithms;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    //int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    //Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    int[] arr = {38, 31, 20, -14, 30,20};
    //Output: [14, 20, 30, 31, 38]
    selectionSort(arr);
  }

  public static void selectionSort(int[] arr){
    int temp;
    for(int i =0 ; i < arr.length; i++){
      int currentLowestIndex = i;
      for(int j = i+1; j < arr.length; j++){
        //System.out.println(arr[i]+ " -- "+ arr[j]+ " --lowest number-- "+arr[currentLowestIndex]);
        if(arr[currentLowestIndex] > arr[j]){
           currentLowestIndex = j;
        }
      }
      // swap with current lowest index, ignore if both are same
      if(currentLowestIndex != i) {
        temp = arr[currentLowestIndex];
        arr[currentLowestIndex] = arr[i];
        arr[i] = temp;
      }
    }
    System.out.println(Arrays.toString(arr));
  }

}
