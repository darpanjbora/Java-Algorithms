/* Alternative way to do the reversal program.
@Author: Rasmus Knoth Nielsen
 */

public class SimpleReversal
{
    public String reverse(String input)
    {
        // Create a StringBuilder to be able to use reverse() method
        StringBuilder output = new StringBuilder();
        // Add the input to our output
        output.append(input);
        // Reverse the string
        output.reverse();
        // Return the StringBuilder, as a string
        return "" + output;
    }

    // Main method to test if the reverse is successful
    public static void main(String[] args) {

        SimpleReversal simpleReversal = new SimpleReversal();
        String string = "Testing string";
        System.out.println("String before reversing: " + string);
        System.out.println("String after reversing: " + simpleReversal.reverse(string));
    }
}