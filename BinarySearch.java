import java.util.Comparator;

import javax.smartcardio.CommandAPDU;

public class BinarySearch{

  // Common description of the below functions:
  // * Precondition: `a` is sorted according to the given comparator.
  // * Precondition: all arguments are non-null (no need to check).
  // * Required complexity: O(log(n)) comparisons where n is the length of `a`.

  
  public static <T> boolean doWhileRecursive(T[] a, T key, int lo, int hi, Comparator<T> comparator){
    if(lo<=hi){
    int mid = (lo+hi)/2;
    int compared = comparator.compare(key, a[mid]);
    if(compared<0){
      return doWhileRecursive(a, key, lo, mid-1, comparator);
    }
    if(compared>0){
      return doWhileRecursive(a, key, mid+1, hi, comparator);
    }
    else{
      return true;
    } 
   }
   return false;
   }
 


  // Check if the array `a` contains the given search key.
  public static <T> boolean contains(T[] a, T key, Comparator<T> comparator) {
  return doWhileRecursive(a, key, 0, a.length-1, comparator); 
  }

  // Return the *first position* of `key` in `a`, or -1 if `key` does not occur.
  public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
    int lo = 0;
    int hi = a.length-1;
    int pos = -1;
    while(lo<=hi){
      int mid = (lo+hi)/2;
      int compared = comparator.compare(key,a[mid]);
      if(compared<0){
        hi = mid-1;
      }
      else if(compared>0){
        lo = mid+1;
      }
      else{
        pos = mid;
        hi = mid-1;
      }
    }
    return pos;
  }

  // Versions of the above functions that use the natural ordering of the type T.
  // T needs to be "comparable" (i.e., implement the interface Comparable).
  // Examples: Integer, String (the alphabetic ordering)

  public static <T extends Comparable<? super T>> boolean contains(T[] a, T key) {
    return contains(a, key, Comparator.naturalOrder());
  }

  public static <T extends Comparable<? super T>> int firstIndexOf(T[] a, T key) {
    return firstIndexOf(a, key, Comparator.naturalOrder());
  }

  // Your tests

  public static <T extends Comparable<T>> void insertionSort(T[] A) {
    for (int i = 1; i < A.length; i++) {
        // Insert i'th record.
        int j = i;
        while (j > 0 && A[j].compareTo(A[j-1]) < 0) {
            swap(A, j, j-1);
            j--;
        }
    }
}
  public static void main(String[] args) {
    Integer[] a = { 1, 3, 5, 7, 9 };
    assert contains(a, 1);
    assert !contains(a, 4);
    assert contains(a, 7);

    //my tests
    assert contains(a, 9);
    assert contains(a, 3);
    assert !contains(a, 6);

    String[] b = { "cat", "cat", "cat", "dog", "turtle", "turtle" };
    assert firstIndexOf(b, "cat") == 0;
    assert firstIndexOf(b, "dog") == 3;
    assert firstIndexOf(b, "turtle") == 4;
    assert firstIndexOf(b, "zebra") == -1;
    assert firstIndexOf(b, "bee") == -1;
  }

}
