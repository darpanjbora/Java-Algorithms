/**
 * Given a integer as a input and replace all the ‘0’ with ‘5’ in the integer.
 * Use of array to store all digits is not allowed.
 */

class ReplaceAll0with5InInputInteger {

    public static int recursivelyReplaceDigits(int num){

        if(num == 0)
            return 0;
        int digit = num %10;
        if(digit == 0)
            digit = 5;
        return recursivelyReplaceDigits(num/10)*10+digit;
    }

    public static int replaceDigits(int num){
        if(num==0)
            return 5;
        return recursivelyReplaceDigits(num);
    }

    public static void main(String [] args){
        System.out.println(replaceDigits(1230450));
        System.out.println(replaceDigits(0));
        System.out.println(replaceDigits(50));
    }
}