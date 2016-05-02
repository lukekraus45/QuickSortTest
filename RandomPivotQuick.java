import java.util.Random;

public class RandomPivotQuick{
	// CS 0445 Spring 2014
	// Simple version of QuickSort.  This is similar to the version in the Carrano
	// text, except that it uses A[last] as the pivot and partitions based on that
	// value.  Compare this to the version of Quicksort in the text (I have copied
	// it into the file TextMergeQuick.java)

	
	public static <T extends Comparable <? super T>> int partition(T[] arr, int left, int right)
	{
		Random rnd = new Random();
	      int i = left, j = right;
	      T tmp;



	      T pivot = arr[left + rnd.nextInt(right - left)];

	      while (i <= j) {
	            while (arr[i].compareTo(pivot) < 0)
	                  i++;
	            while (arr[j].compareTo(pivot) > 0)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };

	      return i;
	}

	public static <T extends Comparable <? super T>> void quickSort(T arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}

	
	
}
