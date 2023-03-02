# Binary Search on soreted lists:
 This class has two static methodes, useful for looking if an array contains an item and finging the frist position that item occurs in the array. 


 - The contains method is implemented in a iterative way: 
    ```java 
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
    ```

- The firstIndexOf method does its job via a helper method that is implemented recursively:
    The helper function: 
    ```java
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
  
    ```
    Then in firstIndexOf just call it: 

    ```java
        public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
            return doWhileRecursive(a, key,0, a.length-1,-1,comparator);
        }
    ```


