
import java.util.*;

//continue with the groupify method, find out a way to split the letter up into groups.

public class Crypto {

    public static void main (String[] args){


        String n = normalizeText("Happy   @*(!&#@!(*     Daysg&#%#");
        String grouped = Groupify(n, 2);
        System.out.println(grouped);

       // String b = shiftAlphabet(2);
        //System.out.println(b);



    }

    public static String normalizeText(String n){

        String withoutSpaces = n.replaceAll("\\s+", "");
        String withoutPunct = withoutSpaces.replaceAll("\\p{P}", "");
        String allUppercase = withoutPunct.toUpperCase();
        n = allUppercase;
        System.out.println(n);
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



