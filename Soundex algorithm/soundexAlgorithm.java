/**
 * The main principle behind this algorithm is that consonants are grouped depending on the ordinal numbers and finally
 * encoded into a value against which others are matched. It aims to find a code for every word by above process
 * which is called soundex code.
 */
public class SoundexAlogorithm {
    private SoundexAlogorithm(){
        //I defiend static method so we don't need to create an isntance
    }

    public static String getSoundexCode(String word) {
        char[] wordArray = word.toUpperCase().toCharArray();
        char firstLetter = wordArray[0];
        for (int i = 0; i < wordArray.length; i++) {
            switch (wordArray[i]) {
                case 'B':
                case 'D':
                case 'F':
                case 'P':
                case 'M':
                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'V':
                    wordArray[i] = '1';
                    break;
                case 'Z':
                    wordArray[i] = '2';
                    break;
                case 'T':
                    wordArray[i] = '3';
                    break;

                case 'L':
                    wordArray[i] = '4';
                    break;

                case 'N':
                    wordArray[i] = '5';
                    break;

                case 'R':
                    wordArray[i] = '6';
                    break;
                default:
                    wordArray[i] = '0';
                    break;
            }
        }
        StringBuilder code = new StringBuilder();
        code.append("").append(firstLetter);
        for (int i = 1; i < wordArray.length; i++) {
            if (wordArray[i] != wordArray[i - 1] && wordArray[i] != '0') code.append(wordArray[i]);
            code = code.append("0000");
        }
        return code.toString.substring(0, 4);
    }
}