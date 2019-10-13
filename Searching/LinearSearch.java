import java.util.Scanner;

public class LinearSearch   
{  

public static int search(int elements[], int element_to_find) 
{ 
    for(int i = 0; i < elements.length; i++) 
    { 
        if(elements[i] == element_to_find) 
            return i; 
    } 
    return -1; 
} 
  
public static void main(String args[]) 
{ 
    Scanner sc = new Scanner(System.in);
     
    System.out.println("Enter the number of Elements you want");
	int number_of_elements = sc.nextInt();
	int elements []= new int[number_of_elements];
	
	System.out.println("Enter the Element to find");
	int finding_element = sc.nextInt();
	System.out.println("Enter elements in Array");
	for (int i = 0; i < number_of_elements; i++) {
		elements[i]= sc.nextInt();
	}
	
    int result = search(elements, finding_element); 
    if(result == -1) 
        System.out.print("Element is not present in array"); 
    else
        System.out.print("Element "+ finding_element + " is present"); 
    
    sc.close();
} 
} 