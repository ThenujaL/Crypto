
import java.util.*;

//write the Caesar Cipher method.

/*for the cypher, start by taking the shifted alphabet from the
given function. Then get the corresponding indexes of the alphabet.
Then save the new string in a variable
 */

public class Crypto {

    public static void main (String[] args){

        String toEncrypt = encryptString("T&H((ENUJA", 1, 2);
        System.out.println(toEncrypt);

    }

    public static String encryptString(String input, int ShiftValue, int groupSize){
        String n = normalizeText(input);
        n = caesarfy(n, ShiftValue);
        n = Groupify(n,groupSize);
        return n;
    }

    public static String caesarfy(String input, int ShiftValue){ //work on getting the indexes and extracting the letters
            String Cyph = "";
            String shiftedPhrase = "";
            String normalAlphabet = shiftAlphabet(0);
            String ShiftedAplhabet = shiftAlphabet(ShiftValue);

        for (int i = 0; i < input.length(); i++){
            Cyph = input.substring(i, i + 1);
            int index = normalAlphabet.indexOf(Cyph);
            String shiftedLetter = ShiftedAplhabet.substring(index, index + 1);
            shiftedPhrase = shiftedPhrase + shiftedLetter;
        }
        return shiftedPhrase;
    }

    public static String normalizeText(String n){

        String withoutSpaces = n.replaceAll("\\s+", "");
        String withoutPunct = withoutSpaces.replaceAll("\\p{P}", "");
        String allUppercase = withoutPunct.toUpperCase();
        n = allUppercase;
        return n;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String Groupify(String n, int group){

        String groupifiedText = "";
        String newGroupifiedText = "";

        if (n.length() % group != 0){
            int amountOfXsToAdd = group - (n.length() % group);

            for (int i = 1; i <= amountOfXsToAdd; i++){
                n = n + "x";
            }

            for (int i = 0; i < n.length(); i+= group){ //for each group

                   groupifiedText = n.substring(i,i+group);

                   if (i < n.length()){
                     newGroupifiedText = newGroupifiedText + groupifiedText + " ";
                   }

            }
            n = newGroupifiedText;
            return n;
        }
        else {
            for (int i = 0; i < n.length(); i+= group) { //for each group

                groupifiedText = n.substring(i, i + group);

                if (i < n.length()) {
                    newGroupifiedText = newGroupifiedText + groupifiedText + " ";
                }
            }
               n = newGroupifiedText;
            return n;
        }
    }

}



