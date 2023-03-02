import java.util.Comparator;

public class BinarySearch{

  // Common description of the below functions:
  // * Precondition: `a` is sorted according to the given comparator.
  // * Precondition: all arguments are non-null (no need to check).
  // * Required complexity: O(log(n)) comparisons where n is the length of `a`.
 
  public static <T> int doWhileRecursive(T[] a, T key, int lo, int hi, int pos, Comparator<T> comparator){
    if(lo<=hi){
    int mid = (lo+hi)/2;
    int compared = comparator.compare(key, a[mid]);
    if(compared<0){
      return doWhileRecursive(a, key, lo, mid-1, pos, comparator);
    }
    if(compared>0){
      return doWhileRecursive(a, key, mid+1, hi, pos, comparator);
    }
    else{
      pos = mid;
      return doWhileRecursive(a, key, lo, mid-1, pos, comparator);
    } 
   }
   return pos;
   }
  


  // Check if the array `a` contains the given search key.
  public static <T> boolean contains(T[] a, T key, Comparator<T> comparator) {
    int lo = 0;
    int hi = a.length-1;
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
        return true;
      }
    }
    return false;    
  }

  // Return the *first position* of `key` in `a`, or -1 if `key` does not occur.
  public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
    return doWhileRecursive(a, key,0, a.length-1,-1,comparator);
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

  // Your tests.

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
