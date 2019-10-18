package String_Reversal;

//Reverse an array without affecting special characters
class GFG 
{ 
    public static void reverse(char str[]) 
    { 
        // Initialize left and right pointers 
        int r = str.length - 1, l = 0; 
  
        // Traverse string from both ends until 
        // 'l' and 'r' 
        while (l < r) 
        { 
            // Ignore special characters 
            if (!Character.isAlphabetic(str[l])) 
                l++; 
            else if(!Character.isAlphabetic(str[r])) 
                r--; 
  
            // Both str[l] and str[r] are not spacial 
            else 
            { 
                char tmp = str[l]; 
                str[l] = str[r]; 
                str[r] = tmp; 
                l++; 
                r--; 
            } 
        } 
    } 
  
    // Driver Code 
    public static void main(String[] args)  
    { 
        String str = "a!!!b.c.d,e'f,ghi"; 
        char[] charArray = str.toCharArray(); 
  
        System.out.println("Input string: " + str); 
                            reverse(charArray); 
        String revStr = new String(charArray); 
  
        System.out.println("Output string: " + revStr); 
    } 
} 
  