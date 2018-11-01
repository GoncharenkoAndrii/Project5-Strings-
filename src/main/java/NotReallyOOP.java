import java.util.Scanner;
import java.util.StringTokenizer;

public class NotReallyOOP {
    private static String TEXT = "Bitcoin: The first ten years\n" +
            "Ten years ago today, Bitcoin was born. A mysterious person going by the fictitious name Satoshi Nakamoto released a paper, saying how his new money would work. It was meant to be a global, digital currency that governments and banks couldn't interfere with.\n" +
            "\n" +
            "So, a decade on, who uses it to trade? And why is Bitcoin itself - which started trading at 30 cents apiece - nowadays worth thousands of dollars?\n" +
            "\n" +
            "Video journalist: Jeremy Howell.";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = 0;
        boolean flag = false;
        while (!flag) {
            System.out.print("Введите длину слов");
            if (sc.hasNextInt()) {
                flag = true;
                len = sc.nextInt();
            } else {
                System.out.println("Ошибка");
                sc.next();
            }
        }
        sc.close();

        // split the text
        StringTokenizer stringTokenizer = new StringTokenizer(TEXT, "\n:.!?", true);
        String last = "";
        String current = "";
        String[] dic = new String[0];
        String[] dicUnique = new String[0];

        while (stringTokenizer.hasMoreTokens()) {
            // save previous token
            last = current;
            // save current token
            current = stringTokenizer.nextToken().trim();
            //System.out.println(current.toString());

            // we look for "?"
            if (current.equals("?") == true) {
                // concatenate current+previous to get full sentence
                String[] dic2 = new String[dic.length + 1];
                System.arraycopy(dic, 0, dic2, 0, dic.length);
                dic2[dic.length] = last + current;
                dic = new String[dic2.length];
                System.arraycopy(dic2, 0, dic, 0, dic2.length);
                //System.out.println(last+current);
            }
        }
        // output for q-sent
        if (dic.length > 0) {
            System.out.println("\nThe list of q-sent is ");
            for (int i = 0; i < dic.length; i++) {
                System.out.println(dic[i]);
            }

            // split the sent

            for (int i = 0; i < dic.length; i++) {
                StringTokenizer stringTokenizer2 = new StringTokenizer(dic[i], " \n\t,.:;!?“”-\"");
                while (stringTokenizer2.hasMoreTokens()) {
                    // getting a word
                    String tok = stringTokenizer2.nextToken().trim();
                    if (tok.length() == len) {
                        // looking for word is already in massive
                        boolean b = false;
                        for (int j = 0; j < dicUnique.length; j++) {
                            String string = dicUnique[j];

                            if (string.equalsIgnoreCase(tok) == true) {
                                b = true;
                                break;
                            }
                        }
                        // if the word is unique - add it
                        if (b == false) {

                            String[] dic2 = new String[dicUnique.length + 1];
                            System.arraycopy(dicUnique, 0, dic2, 0, dicUnique.length);
                            dic2[dicUnique.length] = tok;
                            dicUnique = new String[dic2.length];
                            System.arraycopy(dic2, 0, dicUnique, 0, dic2.length);
                            // System.out.println(tok);
                        }
                    }
                }
            }
            if (dicUnique.length > 0) {
                System.out.printf("\nList of unique words of given length (%d):\n", len);
                for (int i = 0; i < dicUnique.length; i++)
                    System.out.println(dicUnique[i]);
            } else
                System.out.printf("\nNo word fits your demands (%d)!\n", len);
        } else System.out.printf("\nThere are no questionable sent\n", len);
    }
}

