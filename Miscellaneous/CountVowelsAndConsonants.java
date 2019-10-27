import java.util.Scanner;
class VowelCon
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String s = scan.nextLine();
        int l=0,c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                l++;
            else if(s.charAt(i) == ' ')
                continue;
            else
                c++;
        }
        System.out.println("Vowels: " + l);
        System.out.println("Consonants: " + c);
    }
}
