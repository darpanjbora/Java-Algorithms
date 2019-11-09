package Searching;

class BinarySearch {
    int Search(int arr[], int l, int r, int search_element) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == search_element) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > search_element) 
                return Search(arr, l, mid - 1, search_element); 
  
            // Else the element can only be present 
            // in right subarray 
            return Search(arr, mid + 1, r, search_element); 
        } 
 
        return -1; 
    } 
  
    public static void main(String args[]) 
    { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length-1; 
        int search_element = 10; 
        int result = ob.Search(arr, 0, n, search_element); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } 
} 