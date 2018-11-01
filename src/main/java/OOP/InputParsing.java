package OOP;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputParsing {
    /**
     * Outputs welcome message to choose the length of words to look for
     * Waits for users input - if it's integer value - returns it.
     */
    public static int wordLengthInput() {
        Scanner sc = new Scanner(System.in);
        int len = 0;
        boolean flag = false;
        while (!flag) {
            System.out.print("Input words lenght to look for : ");

            if (sc.hasNextInt()) {
                flag = true;
                len = sc.nextInt();
            } else {
                System.out.println("Wrong input. You have to type INTEGER value");
                sc.next();
            }
        }
        sc.close();
        return len;
    }

    /**
     * Takes text as a parameter
     * Returns ArrayList of  sentenses in given text
     */
    public static ArrayList<String> getSentenses(String text) {
        StringTokenizer textTokenizer = new StringTokenizer(text, "\n:.!?", true);
        String last = "";
        String current = "";
        ArrayList<String> listOfSent = new ArrayList<String>();

        while (textTokenizer.hasMoreTokens()) {
            /**
             * The idea is to find stop token "?"(saved in current var) and add it to previous(saved in last var)
             * getting the whole sentense.
             * */
            last = current;
            current = textTokenizer.nextToken().trim();

            if (current.equals("?") == true) {
                listOfSent.add(last + current);
            }

        }
        System.out.println("------------------------------------");
        System.out.println("The list of questionable sentences : ");
        System.out.println("------------------------------------");
        for (String token : listOfSent) {

            System.out.println(token);
        }

        return listOfSent;
    }

    /**
     * Takes an ArrayList of questionable sentenses as a parameter
     * Splits sentenses into words
     * Uses additional method lenghtComparator to find the lenght-fitting words
     * returns an ArrayList of correct words
     */
    public static ArrayList<String> getWordsWithGivenLength(ArrayList<String> sentenses, int wordsLenghtFilter) {
        ArrayList<String> words = new ArrayList<String>();

        for (int current = 0; current < sentenses.size(); current++) {
            StringTokenizer sentenseTokenizer = new StringTokenizer(sentenses.get(current), " \n\t,.:;!?“”-\"");
            while (sentenseTokenizer.hasMoreTokens()) {

                String token = sentenseTokenizer.nextToken().trim();
                //System.out.println(token);

                lengthComparator(token, wordsLenghtFilter, words);

            }
        }
        return words;
    }

    /**
     * Compares the lenght of the word with given length
     * and makes an AraayList of the unique lenght-fitting words
     */
    private static ArrayList<String> lengthComparator(String word, int len, ArrayList<String> addTo) {


        if (word.length() == len) {
            addUniqueToList(addTo, word);
        }
        //System.out.println(addTo);
        return addTo;

    }

    /**
     * Checks if given word is in the list ,
     * if it's not - add it to the list
     */
    private static ArrayList<String> addUniqueToList(ArrayList<String> prevList, String wordToAdd) {


        if (!prevList.contains(wordToAdd)) {
            prevList.add(wordToAdd);
        }

        //System.out.println(prevList);
        return prevList;
    }

    public static void Output(ArrayList<String> uniqueWordsWithGivenLength) {

        if (uniqueWordsWithGivenLength.isEmpty()) {
            System.out.println("There are no words in QUESTIONABLE sentenses with given parameters");
        } else {
            System.out.println("----------------------------------");
            System.out.println("List of words with given filters : ");
            System.out.println("----------------------------------");
            for (String word : uniqueWordsWithGivenLength) {
                System.out.println(word);
            }
        }
    }


}
